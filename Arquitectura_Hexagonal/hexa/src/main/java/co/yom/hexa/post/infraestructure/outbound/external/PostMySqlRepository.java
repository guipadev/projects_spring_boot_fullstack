package co.yom.hexa.post.infraestructure.outbound.external;

import co.yom.hexa.post.domain.model.PostEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostMySqlRepository extends JpaRepository<PostEntity, Long>{
}
