package com.designpattern.builder.mapper;

public class UserService {

    public void populateUser(User user) {
        System.out.println("Inside User Service : User Name : " + user.getFullName());
    }

    public User getUser() {
        User user = new User();
        user.setFullName("Zaheer Ahmed");
        return user;
    }
}
