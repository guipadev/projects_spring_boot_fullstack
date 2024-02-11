package com.api.rest.publicaciones.repository;

import com.api.rest.publicaciones.entitys.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
}
