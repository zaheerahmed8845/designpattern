package org.example.command;

import org.example.entity.Answer;
import org.example.entity.Question;
import org.example.user.UserDirectory;

import java.util.Map;

public class FlagContentHandler implements CommandHandler<FlagContentCommand> {
    private final UserDirectory users;
    private final Map<Long, Question> questions;
    private final Map<Long, Answer> answers;

    public FlagContentHandler(UserDirectory users, Map<Long, Question> qs, Map<Long, Answer> as) {
        this.users = users;
        this.questions = qs;
        this.answers = as;
    }

    public Class<FlagContentCommand> type() {
        return FlagContentCommand.class;
    }

    public void handle(FlagContentCommand c) {
        var user = users.find(c.flaggerId);
        if (c.target == PostTarget.QUESTION) {
            var q = questions.get(c.parentId);
            user.flagQuestion(q, c.reason);
        } else {
            var a = answers.get(c.parentId);
            user.flagAnswer(a, c.reason);
        }
    }
}
