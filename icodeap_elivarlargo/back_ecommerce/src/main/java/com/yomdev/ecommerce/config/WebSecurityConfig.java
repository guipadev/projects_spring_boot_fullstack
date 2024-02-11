package com.yomdev.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailService;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(getEnecoder());
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(requests -> {
                    try {
                        requests
                                .requestMatchers("/administrador/**").hasRole("ADMIN")
                                .requestMatchers("/productosr/**").hasRole("ADMIN")
                                .and().formLogin().loginPage("/usuario/login").permitAll()
                                .defaultSuccessUrl("/usuario/acceder");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .httpBasic();

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder getEnecoder() {
        return new BCryptPasswordEncoder();
    }


}
