package org.example.comm.decorator;

public abstract class CommentaryDecorator implements ICommentary {
    protected final ICommentary inner;

    protected CommentaryDecorator(ICommentary inner) {
        this.inner = inner;
    }
}
