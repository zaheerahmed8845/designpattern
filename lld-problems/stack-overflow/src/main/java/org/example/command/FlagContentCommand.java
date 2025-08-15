package org.example.command;

public class FlagContentCommand implements Command {
    public final PostTarget target;
    public final long parentId;
    public final long flaggerId;
    public final String reason;
    public final String key;

    public FlagContentCommand(PostTarget t, long parentId, long flaggerId, String reason, String key) {
        this.target = t;
        this.parentId = parentId;
        this.flaggerId = flaggerId;
        this.reason = reason;
        this.key = key;
    }

    public String idempotencyKey() {
        return key;
    }
}
