package org.example.entity;

import org.example.component.Comment;
import org.example.component.Post;

public class ContentFactory {

    public Post createPost(User author, String text) {
        return new Post(author, text);
    }

    public Comment createComment(Post post, User author, String text) {
        return new Comment(post, author, text);
    }

    public ConnectionInvitation createConnectionInvitation(User sender, User recipient) {
        return new ConnectionInvitation(sender, recipient);
    }

    public Job createJob(CompanyPage company, String title, String description, String employmentType, Address location) {
        return new Job(company, title, description, employmentType, location);
    }
}
