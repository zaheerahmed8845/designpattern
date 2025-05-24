package org.example.shallow;

import org.example.common.Author;

public class Main {
    public static void main(String[] args) {
        Author author = new Author("J.K. Rowling");
        BookShallow original = new BookShallow("Harry Potter", author);

        BookShallow clone = original.clone();

        if(original == clone){
            System.out.println("Both Original and Clone are equal");
        } else {
            System.out.println("Not Equal");
        }

        System.out.println("Original : "+original);
        System.out.println("Clone : "+clone);

        //Changing authors name
        clone.author.name = "George Orwell";

        System.out.println("\nAfter modifying clone's author name:");
        System.out.println("Original : "+original);
        System.out.println("Clone : "+clone);

    }
}