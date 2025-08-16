package org.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Message {
    private long messageId;
    private User sender;
    private List<User> recipients = new ArrayList<>();
    private String text;
    private List<String> media = new ArrayList<>();
    private LocalDateTime createdAt = LocalDateTime.now();

    public Message(User sender, List<User> recipients, String text) {
        this.sender = sender;
        this.recipients.addAll(recipients);
        this.text = text;
    }
}
