package com.example.demo.controller;

import com.example.demo.dao.UserDTO;
import com.example.demo.exception.BussinessException;
import com.example.demo.exception.RequestException;
import com.example.demo.service.UserFeighClientImpl;
import com.example.demo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl userService;

    // Ṕodemos cambiar userService por userFeighClient que usa la libreria y va a servir igual
    private final UserFeighClientImpl userFeighClient;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {

        return  new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserDTO user) {
        if (user.getEmail().isEmpty()) {
            throw new RequestException("P-401", "Email is required");
        }

        if (user.getName().isEmpty()) {
            throw new RequestException("P-402", "User name is required");
        }

        if (user.getEmail().equals("jorge@gmail.com")) {
            throw new BussinessException("P-300", HttpStatus.INTERNAL_SERVER_ERROR, "Email already");
        }

        UserDTO savedUser = userService.saveUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable("id") Long id, @RequestBody UserDTO user) {

        userService.updateUser(id, user);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id, @RequestBody UserDTO user) {

        userService.deleteUser(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}