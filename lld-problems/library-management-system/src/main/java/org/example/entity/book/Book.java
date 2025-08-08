package org.example.entity.book;

import org.example.entity.Author;
import org.example.enums.BookFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Book {
    protected String ISBN;
    protected String title;
    protected String subject;
    protected String publisher;
    protected LocalDateTime publicationDate;
    protected String language;
    protected int numberOfPages;
    protected BookFormat format;
    protected final List<Author> authors = new ArrayList<>(); // Two-way with Author

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void linkAuthor(Author author) {
        if (!authors.contains(author)) {
            authors.add(author);
            author.linkBook(this);
        }
    }
}

