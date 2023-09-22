package co.yom.jwt.back.services;

import co.yom.jwt.back.dtos.CredentialsDto;
import co.yom.jwt.back.dtos.SignUpDto;
import co.yom.jwt.back.dtos.UserDto;
import co.yom.jwt.back.entites.User;
import co.yom.jwt.back.exceptions.AppException;
import co.yom.jwt.back.mappers.UserMapper;
import co.yom.jwt.back.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto) {
        // En el método, primero busco un usuario con el login
        // Si no lo encuentro, lanzo una excepción
        User user = userRepository.findByLogin(credentialsDto.login())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        // Luego comparo la contraseña dada con la contraseña en la BD
        // Si es correcto, mapeo el usuario de la BD a un DTO de usuario
        // Si no lanzo otra excepción
        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }


    public UserDto register(SignUpDto userDto) {

        Optional<User> optionalUser = userRepository.findByLogin(userDto.login());

        // Devuelva una excepción si el usuario ya está en la BD
        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        // De lo contrario, mapeo el DTO a la entidad
        User user = userMapper.signUpToUser(userDto);
        // codifico la contraseña
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.password())));
        // se salva la entidad
        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public UserDto findByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

}