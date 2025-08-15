package org.example.user;

import java.util.HashMap;
import java.util.Map;

public class UserDirectory { // tiny helper for demo
    private final Map<Long, User> byId = new HashMap<>();

    public void add(User u) {
        byId.put(u.getId(), u);
    }

    public User find(long id) {
        return byId.get(id);
    }
}
