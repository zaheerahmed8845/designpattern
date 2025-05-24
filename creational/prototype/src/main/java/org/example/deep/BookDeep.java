package org.example.deep;

import org.example.common.Author;

public class BookDeep implements Cloneable {
    String title;
    Author author;

    BookDeep(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public BookDeep clone() {
        try {
            BookDeep clone = (BookDeep) super.clone();
            clone.author = new Author(this.author.name); // deep copy
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "BookDeep{title='" + title + "', author=" + author + "}";
    }
}
