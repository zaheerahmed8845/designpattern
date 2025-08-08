package org.example.entity;

import org.example.entity.book.BookItem;

import java.util.ArrayList;
import java.util.List;

public class Rack {
    private int number;
    private String locationIdentifier;
    private final List<BookItem> items = new ArrayList<>();

    public void linkBookItem(BookItem item) {
        if (!items.contains(item)) {
            items.add(item);
            if (item.getRack() != this) item.setRack(this);
        }
    }

    public void unlinkBookItem(BookItem item) {
        items.remove(item);
    }

    public List<BookItem> getItems() {
        return items;
    }
}
