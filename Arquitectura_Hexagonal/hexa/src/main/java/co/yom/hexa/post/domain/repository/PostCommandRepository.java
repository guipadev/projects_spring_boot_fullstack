package co.yom.hexa.post.domain.repository;

import co.yom.hexa.post.domain.model.PostCommand;
import co.yom.hexa.post.domain.model.PostQuery;

import java.util.Optional;

public interface PostCommandRepository {
    Optional<PostQuery> createPost(PostCommand postCommand);
    Optional<PostQuery> updatePost(PostCommand postCommand);
    void deletePost(int id);
}
