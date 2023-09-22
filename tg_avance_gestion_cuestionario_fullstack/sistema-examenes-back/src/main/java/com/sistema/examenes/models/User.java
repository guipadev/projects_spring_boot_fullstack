package com.sistema.examenes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private boolean enabled = true;
    private String profil;

    /**
    * Un Usuario tiene varios Roles
    * Se pone Cascade si se elimina se borran todos los registro relacionados al Usuario
    * EAGER ansioso a esperar y mostra todos los registro LAZY perezoso y muestra lo necesario
    * mappedBY apunta a la entidad propietaria de la relación
    **/
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    @JsonIgnore
    private Set<UserRol> userRoles = new HashSet<>();

    public User() {
    }

    public User(Long id, String username, String password, String name, String lastname, String email, String phone, boolean enabled, String profil, Set<UserRol> userRoles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.enabled = enabled;
        this.profil = profil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    // La cuenta estara activa por un cierto tiempo
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Aqui tambien en true
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Credenciales no van experirar se ponen en true
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Creamos un conjunto de autoridades que viene del paquete modelo
    // Obtenemos los roles y retornar el nombre
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> authorities = new HashSet<>();
        this.userRoles.forEach(userRol -> {
            authorities.add(new Authority(userRol.getRol().getRolName()));
        });
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public Set<UserRol> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRol> userRoles) {
        this.userRoles = userRoles;
    }
}
