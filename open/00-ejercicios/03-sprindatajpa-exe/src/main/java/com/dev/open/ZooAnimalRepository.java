package com.dev.open;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZooAnimalRepository extends JpaRepository<ZooAnimal, Long> {
}
