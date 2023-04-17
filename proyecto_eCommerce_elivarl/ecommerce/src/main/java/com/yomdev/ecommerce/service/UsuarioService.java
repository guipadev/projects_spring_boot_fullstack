package com.yomdev.ecommerce.service;

import com.yomdev.ecommerce.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findById(Integer id);
    Usuario save (Usuario usuario);
    Optional<Usuario> findByEmail(String email);
}
