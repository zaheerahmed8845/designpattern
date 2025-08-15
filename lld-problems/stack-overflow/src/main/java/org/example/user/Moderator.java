package org.example.user;


import org.example.entity.Answer;
import org.example.entity.AuthorizationService;
import org.example.entity.Question;
import org.example.enums.Permission;

public class Moderator extends User {
    private final AuthorizationService auth = new AuthorizationService();

    public Moderator(long id, String name, int reputationPoints) {
        super(id, name, reputationPoints);
    }

    public void closeQuestion(Question q, String reason) {
        auth.check(this, Permission.MOD_CLOSE);
        q.close(reason);
    }

    public void reopenQuestion(Question q) {
        auth.check(this, Permission.MOD_REOPEN);
        q.reopen();
    }

    public void deleteQuestion(Question q) {
        auth.check(this, Permission.MOD_DELETE);
        q.markDeleted();
    }

    public void restoreQuestion(Question q) {
        auth.check(this, Permission.MOD_RESTORE);
        q.restore();
    }

    public void deleteAnswer(Answer a) {
        auth.check(this, Permission.MOD_DELETE);
        a.markDeleted();
    }
}
