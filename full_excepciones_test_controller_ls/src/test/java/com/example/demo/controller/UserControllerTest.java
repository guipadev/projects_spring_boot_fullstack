package com.example.demo.controller;

import com.example.demo.dao.UserDTO;
import com.example.demo.exception.BussinessException;
import com.example.demo.exception.RequestException;
import com.example.demo.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        // Simular el servicio para devolver una lista de usuarios
        when(userService.getAll()).thenReturn(Collections.singletonList(new UserDTO()));

        ResponseEntity<List<UserDTO>> response = userController.getAll();

        // Verificar que la respuesta sea HttpStatus.OK y que contenga una lista de usuarios
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void testSaveUser() {
        UserDTO user = new UserDTO();
        user.setEmail("test@gmail.com");
        user.setName("Test User");

        ResponseEntity response = userController.saveUser(user);

        // Verificar que la respuesta sea HttpStatus.CREATED
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void testSaveUserWithEmptyEmail() {
        UserDTO user = new UserDTO();
        user.setEmail("");
        user.setName("Test User");

        // Simular una excepción de solicitud
        try {
            userController.saveUser(user);
        } catch (RequestException e) {
            assertEquals("P-401", e.getCode() );
            assertEquals("Email is required", e.getMessage());
        }
    }


    @Test
    public void testSaveUserWithDuplicateEmail() {
        UserDTO user = new UserDTO();
        user.setEmail("jorge@gmail.com");
        user.setName("Test User");

        // Similar una excepción de negocio
        when(userService.saveUser(user)).thenThrow(new BussinessException("P-300", HttpStatus.INTERNAL_SERVER_ERROR, "Email already"));



        try {
            userController.saveUser(user);
        } catch (BussinessException e) {
            assertEquals("P-300", e.getCode());
            assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, e.getStatus());
            assertEquals("Email already", e.getMessage());
        }
    }



}