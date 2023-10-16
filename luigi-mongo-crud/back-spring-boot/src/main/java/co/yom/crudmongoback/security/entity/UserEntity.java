package co.yom.crudmongoback.security.entity;

import co.yom.crudmongoback.global.entity.EntityId;
import co.yom.crudmongoback.security.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "users")
public class UserEntity extends EntityId {

    private String username;
    private String email;
    private String password;
    List<RoleEnum> roles;

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }
}
