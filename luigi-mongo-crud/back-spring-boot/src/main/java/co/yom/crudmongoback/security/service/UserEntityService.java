package co.yom.crudmongoback.security.service;

import co.yom.crudmongoback.global.exceptions.AttributeException;
import co.yom.crudmongoback.global.utils.Operations;
import co.yom.crudmongoback.security.dto.CreateUserDto;
import co.yom.crudmongoback.security.entity.UserEntity;
import co.yom.crudmongoback.security.enums.RoleEnum;
import co.yom.crudmongoback.security.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserEntityService {

    private final UserEntityRepository userEntityRepository;

    public UserEntity create(CreateUserDto dto) throws AttributeException {
        if (userEntityRepository.existsByUsername(dto.getUsername()))
            throw new AttributeException("username already in use");

        if (userEntityRepository.existsByEmail(dto.getEmail()))
            throw new AttributeException("email already in use");

        return userEntityRepository.save(mapUserFromDto(dto));
    }

    private UserEntity mapUserFromDto(CreateUserDto dto) {
        int id = Operations.autoIncrement(userEntityRepository.findAll());

        // Convertir List<String> en roles
        List<RoleEnum> roles = dto.getRoles().stream().map(rol -> RoleEnum.valueOf(rol)).collect(Collectors.toList());

        return new UserEntity(dto.getUsername(), dto.getEmail(), dto.getPassword(), roles);
    }

}
