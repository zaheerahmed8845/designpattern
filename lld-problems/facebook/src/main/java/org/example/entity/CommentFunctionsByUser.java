package org.example.entity;

import org.example.observer.Post;

public interface CommentFunctionsByUser {
    Comment createComment(Post post, String text);

    void likeComment(Comment c);
}
