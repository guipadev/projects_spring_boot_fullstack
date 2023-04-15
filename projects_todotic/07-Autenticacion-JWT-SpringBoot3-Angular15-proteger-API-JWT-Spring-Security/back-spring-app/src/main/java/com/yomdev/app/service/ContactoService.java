package com.yomdev.app.service;

import com.yomdev.app.model.Contacto;
import com.yomdev.app.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    public List<Contacto> findAll() {
        return contactoRepository.findAll();
    }

}
