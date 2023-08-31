package co.yom.jwt.back.config;

import co.yom.jwt.back.mappers.UserMapper;
import co.yom.jwt.back.mappers.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

}