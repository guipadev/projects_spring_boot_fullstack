package com.example.demo.service;

import com.example.demo.dao.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Value("${spring.external.service.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate;
    public List<UserDTO> getAll() {
        UserDTO[] response = restTemplate.getForObject(baseUrl + "/users", UserDTO[].class);
        return Arrays.asList(response);

        /*
        return List.of(
                new UserDTO(1L, "Juan", "Madrid", "j@gmail.com"),
                new UserDTO(2L, "Ana", "Lopez", "a@gmail.com"),
                new UserDTO(3L, "Lina", "Marulanda", "l@gmail.com"),
                new UserDTO(4L, "Pilar", "Gonzalez", "p@gmail.com")
        );
        */
    }

    @Override
    public UserDTO saveUser(UserDTO user) {
        restTemplate.postForObject(baseUrl + "/users", user, UserDTO.class);
        return user;
    }

    @Override
    public void updateUser(Long id, UserDTO user) {
        restTemplate.put(baseUrl + "users/" + id, user);
    }

    @Override
    public void deleteUser(Long id) {
        restTemplate.delete(baseUrl + "users/" + id);
    }
}
