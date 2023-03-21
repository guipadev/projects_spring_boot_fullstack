package com.example.obsprindatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
* Se crea Bean para ser detectado en cualquier parte del proyecto
* */
@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {
}
