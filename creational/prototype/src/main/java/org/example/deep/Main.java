package org.example.deep;

import org.example.common.Author;

public class Main {

    public static void main(String[] args) {
        Author author = new Author("J.K. Rowling");
        BookDeep original = new BookDeep("Harry Potter", author);

        BookDeep clone = original.clone();

        if(original == clone){
            System.out.println("Both Original and Clone are equal");
        } else {
            System.out.println("Not Equal");
        }

        System.out.println("Original: " + original);
        System.out.println("Clone   : " + clone);

        clone.author.name = "George Orwell"; // change clone's author

        System.out.println("\nAfter modifying clone's author name:");
        System.out.println("Original: " + original); // unchanged
        System.out.println("Clone   : " + clone);
    }
}
