package co.yom.jwt.back.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserDTO sera un POJO, un objeto Java simple y antiguo
 * Se usara en la recepción y en la transmisión
 * Y no todos los campos se establecerán todos juntos
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String token;

}
