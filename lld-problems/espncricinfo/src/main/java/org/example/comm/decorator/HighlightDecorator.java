package org.example.comm.decorator;

public class HighlightDecorator extends CommentaryDecorator {
    public HighlightDecorator(ICommentary inner) {
        super(inner);
    }

    @Override
    public String render() {
        return "⭐ " + inner.render();
    }
}
