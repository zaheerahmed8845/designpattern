package org.example.entity;

import org.example.enums.Permission;
import org.example.user.User;

public final class AuthorizationService {
    public void check(User user, Permission p) {
        if (!user.has(p)) throw new SecurityException("Forbidden: missing permission " + p);
    }
}
