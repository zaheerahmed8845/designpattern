package org.example.command;

import org.example.entity.Player;
import org.example.entity.TournamentSquad;

public class CreateSquadCommand implements Command {
    private final TournamentSquad squad;
    private final Player player;

    public CreateSquadCommand(TournamentSquad squad, Player player) {
        this.squad = squad;
        this.player = player;
    }

    @Override
    public void execute() {
        squad.addPlayer(player);
    }
}
