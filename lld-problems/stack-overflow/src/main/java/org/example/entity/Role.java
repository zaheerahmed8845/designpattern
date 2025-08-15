package org.example.entity;

import org.example.enums.Permission;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class Role {
    private final String name;
    private final Set<Permission> permissions;

    public Role(String name, Set<Permission> permissions) {
        this.name = Objects.requireNonNull(name);
        this.permissions = EnumSet.copyOf(permissions);
    }

    public String getName() {
        return name;
    }

    public Set<Permission> getPermissions() {
        return Collections.unmodifiableSet(permissions);
    }
}