package com.designpattern.mapper;

public class UserController {

    UserMapper userMapper = new UserMapper();

    UserService userService = new UserService();

    public void populateUser(UserDTO userDTO) {
        System.out.println("Inside User Controller : Populating the User");
        User user = userMapper.toUser(userDTO);
        userService.populateUser(user);
    }

    public UserDTO getUser() {
        System.out.println("Inside User Controller : Fetching the User");
        User user = userService.getUser();
        return userMapper.toDTO(user);
    }
}
