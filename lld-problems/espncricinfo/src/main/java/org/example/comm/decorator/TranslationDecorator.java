package org.example.comm.decorator;

public class TranslationDecorator extends CommentaryDecorator {
    private final String translated;

    public TranslationDecorator(ICommentary inner, String translated) {
        super(inner);
        this.translated = translated;
    }

    @Override
    public String render() {
        return inner.render() + " | (TR) " + translated;
    }
}
