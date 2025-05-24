package org.example.shallow;

import org.example.common.Author;

public class BookShallow implements Cloneable {

    String title;
    Author author;

    public BookShallow(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public BookShallow clone() {
        try {
            return (BookShallow) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author=" + author + "}";
    }

}
