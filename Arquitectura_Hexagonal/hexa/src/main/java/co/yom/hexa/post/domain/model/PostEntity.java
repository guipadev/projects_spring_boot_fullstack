package co.yom.hexa.post.domain.model;

import lombok.Data;

@Data
public class PostEntity {
    private Long userId;
    private Long id;
    private String title;
    private String body;
}
