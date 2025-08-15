package org.example.entity;

import org.example.observer.Post;
import org.example.strategy.PrivacyStrategy;

public interface PageFunctionsByUser {
    void followPage(Page p);

    void unfollowPage(Page p);

    Post createPagePost(Page p, String content, PrivacyStrategy privacy);
}
