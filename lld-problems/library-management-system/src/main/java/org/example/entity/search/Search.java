package org.example.entity.search;

import org.example.entity.book.Book;

import java.time.LocalDateTime;
import java.util.List;

public interface Search {
    List<Book> searchByTitle(String title);

    List<Book> searchByAuthor(String author);

    List<Book> searchBySubject(String subject);

    List<Book> searchByPubDate(LocalDateTime publishDate);
}
