package org.example.entity;

import org.example.entity.book.BookItem;

import java.util.ArrayList;
import java.util.List;

class Library {
    private String name;
    private Address address;
    private final List<BookItem> bookItems = new ArrayList<>(); // Composition: Library composed of BookItems

    public void addBookItem(BookItem item) {
        bookItems.add(item);
    }

    public List<BookItem> getBookItems() {
        return bookItems;
    }
}
