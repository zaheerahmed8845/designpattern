package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int groupId;
    private String name;
    private String description;
    private List<User> members = new ArrayList<>();

    public Group(int groupId, String name, String description) {
        this.groupId = groupId;
        this.name = name;
        this.description = description;
    }

    public void addMember(User u) {
        members.add(u);
    }

    public List<User> getMembers() {
        return members;
    }

    public void updateDescription(String d) {
        this.description = d;
    }
}
