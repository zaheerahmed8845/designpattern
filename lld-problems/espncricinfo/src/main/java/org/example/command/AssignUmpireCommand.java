package org.example.command;

import org.example.entity.Umpire;
import org.example.match.Match;

public class AssignUmpireCommand implements Command {
    private final Match match;
    private final Umpire umpire;

    public AssignUmpireCommand(Match match, Umpire umpire) {
        this.match = match;
        this.umpire = umpire;
    }

    @Override
    public void execute() {
        match.assignUmpire(umpire);
    }
}
