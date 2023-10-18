package co.yom.crudmongoback.security.repository;

import co.yom.crudmongoback.security.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends MongoRepository<UserEntity, Integer> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    // Sabe que pasaremos 2 campos y va a buscar usuarios que coincidan por el nombre o email
    Optional<UserEntity> findByUsernameOrEmail(String username, String email);
}
