package co.yom.jwt.back.mappers;

import co.yom.jwt.back.dtos.SignUpDto;
import co.yom.jwt.back.dtos.UserDto;
import co.yom.jwt.back.entites.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }

    @Override
    public User signUpToUser(SignUpDto signUpDto) {
        User user = new User();

        user.setLogin(signUpDto.login());
        user.setFirstName(signUpDto.firstName());
        user.setLastName(signUpDto.lastName());

        return user;
    }

}