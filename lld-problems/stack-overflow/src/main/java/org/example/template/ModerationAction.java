package org.example.template;

import org.example.user.User;

public abstract class ModerationAction {
    public final void execute(User actor) {
        validate(actor);
        checkPermissions(actor);
        apply();
        audit(actor);
        notifyParties();
    }

    protected abstract void validate(User actor);

    protected abstract void checkPermissions(User actor);

    protected abstract void apply();

    protected void audit(User a) {
        System.out.println("[Audit] " + getClass().getSimpleName() + " by user " + a.getId());
    }

    protected void notifyParties() { /* hook into events/notifications */ }
}
