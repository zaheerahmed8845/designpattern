package org.example.entity;

import org.example.person.User;

import java.util.HashSet;
import java.util.Set;

public class Group {
    private static int SEQ = 1;
    private final String id = "grp-" + (SEQ++);
    private String name;
    private final Set<User> members = new HashSet<>();

    public Group(String name) {
        this.name = name;
    }

    public void addUser(User u) {
        members.add(u);
    }

    public void removeUser(User u) {
        members.remove(u);
    }

    public int size() {
        return members.size();
    }

    @Override
    public String toString() {
        return "Group(" + name + ", members=" + members.size() + ")";
    }
}
