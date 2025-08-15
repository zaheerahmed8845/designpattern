package org.example.entity;

import org.example.observer.Post;
import org.example.strategy.PrivacyStrategy;

public interface PostFunctionsByUser {
    Post createPost(String content, PrivacyStrategy privacy);

    void likePost(Post post);

    Comment commentOnPost(Post post, String text);

    void sharePost(Post post); // simplified
}
