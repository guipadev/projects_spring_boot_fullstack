package com.example.demo.service;

import com.example.demo.dao.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAll();

    default UserDTO saveUser(UserDTO user) {
        return user;
    }

    default void updateUser(Long id, UserDTO user) {}

    default void deleteUser(Long id) {}
}
