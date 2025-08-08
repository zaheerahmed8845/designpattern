package org.example.entity.book;

import org.example.enums.BookFormat;

// Factory Pattern - This is a Simple Factory Method and not a Factory-Method pattern
public class BookFactory {
    public static BookItem createBookItem(String ISBN, String title, String subject, BookFormat format) {
        BookItem bookItem = new BookItem();
        bookItem.ISBN = ISBN;
        bookItem.title = title;
        bookItem.subject = subject;
        bookItem.format = format;
        bookItem.setAvailable();
        return bookItem;
    }
}
