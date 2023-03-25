package com.designpattern.mapper;

public class Main {

    private static UserController userController = new UserController();

    public static void main(String[] args) {
        System.out.println("Inside Main : Populating the User");
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Zaheer Ahmed");
        userController.populateUser(userDTO);
        System.out.println("**************************************");
        System.out.println("Inside Main : Fetching the User");
        userController.getUser();
    }
}
