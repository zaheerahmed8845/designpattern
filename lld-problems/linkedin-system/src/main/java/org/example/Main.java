package org.example;

import org.example.component.Comment;
import org.example.component.ContentComponent;
import org.example.component.Post;
import org.example.component.decorator.ReactionDecorator;
import org.example.component.decorator.ShareDecorator;
import org.example.entity.*;
import org.example.event.DomainEventBus;
import org.example.event.NotificationService;
import org.example.strategy.JobSearchStrategy;

public class Main {
    public static void main(String[] args) {
        // Wire Observer singletons
        DomainEventBus.getInstance().register(NotificationService.getInstance());

        // Users
        Address blr = new Address("560001", "MG Road", "Bengaluru", "KA", "IN");
        User alice = new User(1, "Alice", blr, "999-111", "alice@example.com", "secret");
        User bob = new User(2, "Bob", blr, "999-222", "bob@example.com", "secret");

        // Factory: create post & comment
        ContentFactory factory = new ContentFactory();
        Post post = factory.createPost(alice, "Excited to share my new article on distributed systems!");
        Comment c1 = factory.createComment(post, bob, "Congrats! Looking forward to reading it.");

        // Decorator: add richer behavior to post (reactions & share stats) without changing Post
        ContentComponent decorated =
                new ShareDecorator(new ReactionDecorator(post));
        decorated.addReaction("LIKE");
        decorated.addReaction("CELEBRATE");
        decorated.share(bob);
        decorated.reply(bob, "Also shared with my team!");

        // Connection invitation flow via Factory + Observer
        ConnectionInvitation invite = factory.createConnectionInvitation(alice, bob);
        invite.acceptConnection(); // publishes event

        // Singleton + Strategy: switch search behaviors on the fly
        SearchService search = SearchService.getInstance();
        System.out.println("People search: " + search.search("Zaheer"));
        search.setStrategy(new JobSearchStrategy());
        System.out.println("Job search: " + search.search("Platform Engineer"));

        // Company / Job via Factory
        CompanyPage gs = alice.createCompanyPage(101, "Goldman Sachs", "Finance & Tech", "Private", 10000);
        Job job = factory.createJob(gs, "Principal Engineer", "Own core services", "Full-time", blr);
        System.out.println(job);

        // Drain notifications produced by Observer reactions
        System.out.println("\nNotifications:");
        for (Notification n : NotificationService.getInstance().drain()) {
            System.out.println(" - " + n.getContent());
        }

        // Quick readout
        System.out.println("\nPost stats: reactions=" + decorated.getReactionCount()
                + ", shares=" + decorated.getShareCount()
                + ", comments=" + decorated.getComments().size());
    }
}