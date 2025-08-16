package org.example.event;

import org.example.component.Post;

public class PostCreatedEvent implements Event {
    private final Post post;

    public PostCreatedEvent(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}
