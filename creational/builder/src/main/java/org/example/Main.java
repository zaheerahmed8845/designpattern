package org.example;

public class Main {
    public static void main(String[] args) {
        User user1 = new User.UserBuilder("User", "1")
                .age(1)
                .phone(23434)
                .address("Kar")
                .build();

        User user2 = new User.UserBuilder("User", "2")
                .age(2)
                .phone(54321)
                .address("Mad")
                .build();

        System.out.println(user1);

        System.out.println(user2);

    }
}