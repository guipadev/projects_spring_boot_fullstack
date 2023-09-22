package com.yomdev.ecommerce.repository;

import com.yomdev.ecommerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
