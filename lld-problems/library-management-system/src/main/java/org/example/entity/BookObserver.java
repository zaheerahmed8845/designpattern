package org.example.entity;

import org.example.entity.book.BookItem;

public interface BookObserver {
    void onBookAvailable(BookItem bookItem);
}
