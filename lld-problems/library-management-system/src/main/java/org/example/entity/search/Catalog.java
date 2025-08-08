package org.example.entity.search;

import org.example.entity.Author;
import org.example.entity.book.Book;

import java.time.LocalDateTime;
import java.util.List;

public class Catalog implements Search {
    private List<Book> bookTitles;
    private List<Author> bookAuthors;
    private List<String> bookSubjects;
    private List<LocalDateTime> bookPublicationDates;

    public List<Book> searchByTitle(String query) {
        return null;
    }

    public List<Book> searchByAuthor(String query) {
        return null;
    }

    public List<Book> searchBySubject(String query) {
        return null;
    }

    public List<Book> searchByPubDate(LocalDateTime publishDate) {
        return null;
    }
}
