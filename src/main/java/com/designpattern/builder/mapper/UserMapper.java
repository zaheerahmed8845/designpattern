package com.designpattern.builder.mapper;

public class UserMapper {

    public UserDTO toDTO(User user) {
        System.out.println("Mapping User to UserDTO");
        UserDTO userVO = new UserDTO();
        userVO.setName(user.getFullName());
        return userVO;
    }

    public User toUser(UserDTO userDTO) {
        System.out.println("Mapping UserDTO to User");
        User user = new User();
        user.setFullName(userDTO.getName());
        return user;
    }
}
