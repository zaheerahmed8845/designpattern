package org.example;

import org.example.entity.FriendRequest;
import org.example.entity.Group;
import org.example.entity.Page;
import org.example.observer.Post;
import org.example.person.User;
import org.example.search.SearchCatalog;
import org.example.strategy.FriendsOfFriendsPrivacy;
import org.example.strategy.FriendsOnlyPrivacy;
import org.example.strategy.PublicPrivacy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Users
        User alice = new User("Alice");
        User bob = new User("Bob");
        User carol = new User("Carol");

        // Index users (Singleton)
        SearchCatalog.getInstance().indexUser(alice);
        SearchCatalog.getInstance().indexUser(bob);
        SearchCatalog.getInstance().indexUser(carol);

        // Friend request (State)
        FriendRequest fr = new FriendRequest(alice, bob);
        System.out.println("FR Status = " + fr.getStatus());
        fr.accept();
        System.out.println("FR Status = " + fr.getStatus());
        System.out.println("Alice & Bob friends? " + alice.isFriend(bob));

        // Alice posts with different privacy strategies (Strategy + Observer + Factory)
        Post p1 = alice.createPost("Hello World (Public)", new PublicPrivacy());
        Post p2 = alice.createPost("Friends only news", new FriendsOnlyPrivacy());
        Post p3 = alice.createPost("FoF secret", new FriendsOfFriendsPrivacy());

        // Carol is not a friend; Bob is a friend. Carol is friend-of-friend via Bob.
        // Carol views posts (Strategy check)
        System.out.println("Carol can see p1? " + p1.canView(carol)); // true
        System.out.println("Carol can see p2? " + p2.canView(carol)); // false
        System.out.println("Carol can see p3? " + p3.canView(carol)); // true (FoF through Bob)

        // Bob comments on p2, Alice gets notified (Observer + Factory)
        bob.commentOnPost(p2, "Nice one!");

        // Page & Group (ISP usage)
        Page techPage = new Page("Tech");
        carol.followPage(techPage);
        carol.createPagePost(techPage, "New gadget launched!", new PublicPrivacy());

        Group dsGroup = new Group("Distributed Systems");
        bob.createGroup(dsGroup);
        alice.joinGroup(dsGroup);

        // Messaging (Factory notifications)
        alice.sendMessage("Hey Bob!", bob);

        // Global search (Singleton) respecting privacy
        List<Post> visibleToCarol = SearchCatalog.getInstance().searchPostsVisibleTo("Hello", carol);
        System.out.println("Search 'Hello' visible to Carol -> " + visibleToCarol.size() + " result(s)");

        // Show Bob's inbox
        System.out.println("\n--- Bob's Inbox ---");
        bob.getInbox().forEach(System.out::println);

        // Show Alice's inbox (notifications about comments/likes/messages)
        System.out.println("\n--- Alice's Inbox ---");
        alice.getInbox().forEach(System.out::println);
    }
}