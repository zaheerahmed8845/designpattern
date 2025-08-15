package org.example.user;

import org.example.decorator.BaseUserCapabilities;
import org.example.decorator.BlockedUserDecorator;
import org.example.entity.AuthorizationService;
import org.example.entity.Badge;
import org.example.enums.Permission;
import org.example.enums.UserStatus;

public class Admin extends User {
    private final AuthorizationService auth = new AuthorizationService();

    public Admin(long id, String name, int reputationPoints) {
        super(id, name, reputationPoints);
    }

    public void awardBadge(User user, Badge badge) {
        auth.check(this, Permission.ADMIN_AWARD_BADGE);
        user.addBadge(badge);
    }

    public void blockUser(User user) {
        auth.check(this, Permission.ADMIN_BLOCK);
        user.setStatus(UserStatus.BLOCKED);
        user.setCapabilities(new BlockedUserDecorator(new BaseUserCapabilities()));
    }

    public void unblockUser(User user) {
        auth.check(this, Permission.ADMIN_UNBLOCK);
        user.setStatus(UserStatus.ACTIVE);
        user.setCapabilities(new BaseUserCapabilities());
    }
}
