package com.yomdev.ecommerce.repository;

import com.yomdev.ecommerce.model.Orden;
import com.yomdev.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenRepository extends JpaRepository<Orden, Integer> {

    List<Orden> findByUsuario (Usuario usuario);
}
