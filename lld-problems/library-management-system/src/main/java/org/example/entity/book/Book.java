package org.example.entity.book;

import org.example.entity.Author;
import org.example.enums.BookFormat;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Book {
    protected String ISBN;
    public String title;
    protected String subject;
    protected String publisher;
    protected LocalDateTime publicationDate;
    protected String language;
    protected int numberOfPages;
    protected BookFormat format;
    protected List<Author> authors;

    public String getTitle() {
        return title;
    }
}
