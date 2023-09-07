package com.example.demo.service;

import com.example.demo.configuration.FeignClientConfig;
import com.example.demo.dao.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name ="USER-MOCK-API", url = "${spring.external.service.base-url}", configuration = FeignClientConfig.class)
public interface UserFeighClient {

    @GetMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<UserDTO> getUsers();

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    UserDTO saveUser(@RequestBody UserDTO user);

    @PutMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    UserDTO updateUser(@PathVariable("id") Long id, @RequestBody UserDTO user);

    @DeleteMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    UserDTO deleteUser(@PathVariable("id") Long id);
}

