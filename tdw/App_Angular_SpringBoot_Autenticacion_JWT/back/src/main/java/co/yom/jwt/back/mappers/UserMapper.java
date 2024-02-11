    package co.yom.jwt.back.mappers;

    import co.yom.jwt.back.dtos.SignUpDto;
    import co.yom.jwt.back.dtos.UserDto;
    import co.yom.jwt.back.entites.User;
    import org.mapstruct.Mapper;
    import org.mapstruct.Mapping;

    /**
     * Un mapper con Mapstruct para asignar la entidad del usuario al DTO del usuario
     */

    @Mapper
    public interface UserMapper {

        UserDto toUserDto(User user);

        // Se ignora la contraseña xq es de un formato diferente
        // Tiene una lista de caracteres en el DTO de registro (record SignUpDto - char[] passsword)
        // y una cadena en el objeto de usuario class User - String password
        @Mapping(target = "password", ignore = false)
        User signUpToUser(SignUpDto signUpDto);

    }