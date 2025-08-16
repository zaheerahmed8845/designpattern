package org.example;

import org.example.comm.decorator.BasicCommentary;
import org.example.comm.decorator.HighlightDecorator;
import org.example.comm.decorator.ICommentary;
import org.example.comm.decorator.LiveStatsDecorator;
import org.example.command.AddNewsCommand;
import org.example.command.AssignUmpireCommand;
import org.example.entity.*;
import org.example.enums.PlayingPosition;
import org.example.match.Match;
import org.example.match.MatchBuilder;
import org.example.match.MatchFactory;
import org.example.observer.ConsoleCommentaryObserver;
import org.example.observer.ConsoleNotificationObserver;
import org.example.observer.MatchEvent;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Teams & players
        Team ind = new Team("India");
        Team aus = new Team("Australia");

        Player rohit = new Player("R. Sharma", 36, "India", PlayingPosition.BATSMAN);
        Player bumrah = new Player("J. Bumrah", 31, "India", PlayingPosition.BOWLER);
        Player warner = new Player("D. Warner", 38, "Australia", PlayingPosition.BATSMAN);

        ind.addPlayer(rohit);
        ind.addPlayer(bumrah);
        aus.addPlayer(warner);

        // Tournament
        Tournament wc = new Tournament("World Cup 2031");
        wc.addTeam(ind);
        wc.addTeam(aus);

        // Stadium
        Stadium wankhede = new Stadium("Wankhede",
                new Address("D Rd", "Mumbai", "MH", "400020", "India"), 33000);

        // Playing XI
        Playing11 indXI = new Playing11();
        indXI.addPlayer(rohit);
        indXI.addPlayer(bumrah);
        Playing11 ausXI = new Playing11();
        ausXI.addPlayer(warner);

        // Build match via Builder (+ Factory inside)
        Match match = new MatchBuilder(MatchFactory.Type.ODI)
                .teams(ind, aus)
                .stadium(wankhede)
                .start(LocalDateTime.now())
                .playing11(indXI, ausXI)
                .build();

        // Observer subscribers
        match.register(new ConsoleCommentaryObserver());
        match.register(new ConsoleNotificationObserver());

        // Commands: assign umpires, add news, create squad entries
        Invoker invoker = new Invoker();
        invoker.submit(new AssignUmpireCommand(match, new Umpire("K. Dharmasena", "SL")));
        invoker.submit(new AddNewsCommand(ind, new News("India announce XI")));
        invoker.runAll();

        // Decorator: compose rich commentary
        ICommentary c = new BasicCommentary("Rohit pulls fiercely for four!");
        c = new HighlightDecorator(new LiveStatsDecorator(c, "Rohit 28(14)"));
        System.out.println(c.render());

        // Strategy demo
        System.out.println(rohit.performRole());
        System.out.println(bumrah.performRole());

        // Fire some match events
        match.notifyAllObservers(new MatchEvent(MatchEvent.Kind.RUN, match, "FOUR! India 32/0"));
        match.notifyAllObservers(new MatchEvent(MatchEvent.Kind.WICKET, match, "Warner c&b Bumrah 0"));

        // Template method (stubbed flow)
        match.playMatch();

        // Singleton Admin registers everything
        Admin admin = Admin.getInstance();
        admin.addTeam(ind);
        admin.addTeam(aus);
        admin.addTournament(wc);
        admin.addMatch(match);
    }
}