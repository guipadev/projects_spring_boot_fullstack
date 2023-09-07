package com.example.demo.service;

import com.example.demo.dao.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFeighClientImpl {

    private final UserFeighClient client;

    public List<UserDTO> getUsers() {
        List<UserDTO> response = client.getUsers();
        return response;
    }

    public void saveUser(UserDTO user) {
        client.saveUser(user);
    }

    public void updateUser(Long id, UserDTO user) {
        client.updateUser(id, user);
    }

    public void deleteUser(Long id) {
        client.deleteUser(id);
    }
}
