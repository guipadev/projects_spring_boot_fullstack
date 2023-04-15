package com.yomdev.app.controller;

import com.yomdev.app.model.Contacto;
import com.yomdev.app.service.ContactoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contactos")
@AllArgsConstructor
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping
    public List<Contacto> listContacto() {
        return contactoService.findAll();
    }
}
