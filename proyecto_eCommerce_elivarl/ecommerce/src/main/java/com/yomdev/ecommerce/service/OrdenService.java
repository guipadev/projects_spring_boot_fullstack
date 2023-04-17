package com.yomdev.ecommerce.service;

import com.yomdev.ecommerce.model.Orden;
import com.yomdev.ecommerce.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface OrdenService {

    List<Orden> findAll();
    Optional<Orden> findById(Integer id);
    Orden save (Orden orden);
    String generarNumeroOrden();
    List<Orden> findByUsuario (Usuario usuario);
}
