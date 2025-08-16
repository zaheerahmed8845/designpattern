package org.example.comm.decorator;

public class BasicCommentary implements ICommentary {
    private final String base;

    public BasicCommentary(String base) {
        this.base = base;
    }

    @Override
    public String render() {
        return base;
    }
}
