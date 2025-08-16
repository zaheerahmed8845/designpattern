package org.example.comm.decorator;

public class LiveStatsDecorator extends CommentaryDecorator {
    private final String statsSnippet;

    public LiveStatsDecorator(ICommentary inner, String statsSnippet) {
        super(inner);
        this.statsSnippet = statsSnippet;
    }

    @Override
    public String render() {
        return inner.render() + " | Stats: " + statsSnippet;
    }
}
