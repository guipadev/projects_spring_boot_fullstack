package co.yom.crudmongoback.security.service;

import co.yom.crudmongoback.security.entity.UserEntity;
import co.yom.crudmongoback.security.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserEntityRepository userEntityRepository;

    // Obtener los usuarios del almacen osea de los Document de Mongo

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userEntityRepository.findByUsernameOrEmail(username, username);

        if(!userEntity.isPresent())
            return null;

        return UserPrincipal.build(userEntity.get());
    }
}
