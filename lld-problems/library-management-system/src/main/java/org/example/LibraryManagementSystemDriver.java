package org.example;

import org.example.entity.MemberFactory;
import org.example.entity.book.BookFactory;
import org.example.entity.book.BookItem;
import org.example.entity.user.Member;
import org.example.enums.BookFormat;

public class LibraryManagementSystemDriver {
    public static void main(String[] args) {
        BookItem bookItem = BookFactory.createBookItem("123-456", "Design Patterns", "Software", BookFormat.HARDCOVER);
        Member member = MemberFactory.createMember("M001", "John Doe");

        member.reserveBookItem(bookItem); // Registers observer

        // Simulate book becoming available
        bookItem.setAvailable();

        member.checkoutBookItem(bookItem);

        System.out.println("Library Management System initialized.");
    }
}