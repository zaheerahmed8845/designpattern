package org.example;

import org.example.command.*;
import org.example.decorator.BaseUserCapabilities;
import org.example.entity.Answer;
import org.example.entity.Question;
import org.example.entity.Role;
import org.example.entity.Tag;
import org.example.enums.Permission;
import org.example.event.*;
import org.example.factory.DefaultContentFactory;
import org.example.search.SearchCatalog;
import org.example.search.SearchService;
import org.example.search.TagSearchStrategy;
import org.example.template.CloseQuestionAction;
import org.example.user.Admin;
import org.example.user.Moderator;
import org.example.user.User;
import org.example.user.UserDirectory;
import org.example.util.IdGen;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Infra
        var events = new DomainEventPublisher();
        var users = new UserDirectory();
        var notification = new NotificationService();
        var searchCatalog = new SearchCatalog();
        var badgeService = new BadgeService(events, users);
        events.subscribe(AnswerAddedEvent.class, badgeService);
        events.subscribe(DomainEvent.class, notification); // generic notifier

        // Roles
        var roleUser = new Role("user", EnumSet.of(Permission.POST_QUESTION, Permission.POST_ANSWER, Permission.POST_COMMENT, Permission.FLAG));
        var roleMod = new Role("moderator", EnumSet.of(Permission.MOD_CLOSE, Permission.MOD_REOPEN, Permission.MOD_DELETE, Permission.MOD_RESTORE));
        var roleAdmin = new Role("admin", EnumSet.of(Permission.ADMIN_AWARD_BADGE, Permission.ADMIN_BLOCK, Permission.ADMIN_UNBLOCK));

        // Accounts
        var alice = new User(IdGen.next(), "alice", 100);
        alice.addRole(roleUser);
        users.add(alice);
        var bob = new Moderator(IdGen.next(), "bob-mod", 1000);
        bob.addRole(roleUser);
        bob.addRole(roleMod);
        users.add(bob);
        var carol = new Admin(IdGen.next(), "carol-admin", 5000);
        carol.addRole(roleUser);
        carol.addRole(roleAdmin);
        users.add(carol);

        // Factory
        var factory = new DefaultContentFactory();

        // Alice creates & publishes a question
        var q = factory.newQuestion(alice, "How to implement Observer in Java?", "Need an example with events.", List.of(new Tag("java", ""), new Tag("design-patterns", "")));
        alice.publishQuestion(q);
        searchCatalog.indexQuestion(q);

        // Bob answers → publish event (Observer)
        var ans = factory.newAnswer(bob, "Use an event bus with handler registry...");
        alice.addAnswer(q, ans); // in diagram User.addAnswer(user, answer) is present; here the actor is Bob via method call; for demo keep simple
        events.publish(new AnswerAddedEvent(q.getId(), ans.getId(), bob.getId()));

        // Strategy search
        var searchService = new SearchService();
        System.out.println("Search by tag 'java': " + searchService.search("java", new TagSearchStrategy(searchCatalog)).size());

        // Composite: nested comment
        var c1 = factory.newComment(alice, "Thanks!");
        alice.addCommentToQuestion(q, c1);
        var c1r = factory.newComment(bob, "You're welcome");
        c1.addChild(c1r);
        events.publish(new CommentAddedEvent(q.getId(), false, c1.getId(), alice.getId()));

        // Command: add comment later + flag
        var questions = new HashMap<Long, Question>();
        questions.put(q.getId(), q);
        var answers = new HashMap<Long, Answer>();
        answers.put(ans.getId(), ans);
        var bus = new CommandBus();
        bus.register(new AddCommentHandler(users, questions, answers, factory, events));
        bus.register(new FlagContentHandler(users, questions, answers));
        bus.submit(new AddCommentCommand(PostTarget.ANSWER, ans.getId(), alice.getId(), "Please add code sample.", UUID.randomUUID().toString()));
        bus.submit(new FlagContentCommand(PostTarget.QUESTION, q.getId(), alice.getId(), "needs details", UUID.randomUUID().toString()));

        // Template Method: moderator closes the question
        new CloseQuestionAction(bob, q, "Needs details", events).execute(bob);

        // Decorator: admin blocks Alice (capabilities shut off)
        carol.blockUser(alice);
        System.out.println("Alice can comment now? " + new BaseUserCapabilities().canComment(alice));

        System.out.println("Demo complete. Status=" + q.getStatus());
    }
}
