package org.example.command;

import org.example.entity.News;
import org.example.entity.Team;

public class AddNewsCommand implements Command {
    private final Team team;
    private final News news;

    public AddNewsCommand(Team team, News news) {
        this.team = team;
        this.news = news;
    }

    @Override
    public void execute() {
        team.addNews(news);
    }
}
