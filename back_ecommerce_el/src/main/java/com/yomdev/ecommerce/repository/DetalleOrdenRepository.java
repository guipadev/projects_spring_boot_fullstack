package com.yomdev.ecommerce.repository;

import com.yomdev.ecommerce.model.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Integer> {
}
