package com.project.coches.persistance.crud;

import com.project.coches.persistance.entity.BrandCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandCardCrudRepository extends JpaRepository<BrandCarEntity, Integer> {
}
