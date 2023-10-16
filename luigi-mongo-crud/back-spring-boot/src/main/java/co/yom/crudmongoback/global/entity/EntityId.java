package co.yom.crudmongoback.global.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public abstract class EntityId {

    @Id
    protected int id;
}
