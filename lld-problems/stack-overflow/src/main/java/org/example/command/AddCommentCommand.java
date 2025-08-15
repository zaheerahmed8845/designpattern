package org.example.command;

public class AddCommentCommand implements Command {
    public final PostTarget target;
    public final long parentId;
    public final long authorId;
    public final String text;
    public final String key;

    public AddCommentCommand(PostTarget t, long parentId, long authorId, String text, String key) {
        this.target = t;
        this.parentId = parentId;
        this.authorId = authorId;
        this.text = text;
        this.key = key;
    }

    public String idempotencyKey() {
        return key;
    }
}
