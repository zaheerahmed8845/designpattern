package org.example.entity;

import org.example.entity.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private String description;
    private final List<Book> authoredBooks = new ArrayList<>(); // Two-way

    public String getName() {
        return name;
    }

    public List<Book> getAuthoredBooks() {
        return authoredBooks;
    }

    public void linkBook(Book book) {
        if (!authoredBooks.contains(book)) {
            authoredBooks.add(book);
            book.linkAuthor(this);
        }
    }
}
