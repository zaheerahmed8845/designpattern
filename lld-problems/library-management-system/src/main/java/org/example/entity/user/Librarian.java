package org.example.entity.user;

import org.example.entity.book.BookItem;
import org.example.enums.AccountStatus;
import org.example.enums.BookStatus;

import java.util.ArrayList;
import java.util.List;

public class Librarian extends User {
    private final List<BookItem> managedBookItems = new ArrayList<>(); // Two-way

    public void addBookItem(BookItem bookItem) {
        manageBookItem(bookItem);
        bookItem.setStatus(BookStatus.AVAILABLE);
    }

    public void manageBookItem(BookItem bookItem) {
        if (!managedBookItems.contains(bookItem)) {
            managedBookItems.add(bookItem);
            bookItem.linkLibrarian(this);
        }
    }

    public void blockMember(Member member) {
        member.status = AccountStatus.BLACKLISTED;
    }

    public void unBlockMember(Member member) {
        member.status = AccountStatus.ACTIVE;
    }

    public List<BookItem> getManagedBookItems() {
        return managedBookItems;
    }
}
