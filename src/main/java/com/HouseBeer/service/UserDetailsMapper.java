package com.HouseBeer.service;

import com.HouseBeer.entity.Rol;
import com.HouseBeer.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsMapper {
    public static UserDetails build(Usuario user) {
        return new org.springframework.security.core.userdetails.User(user.getNombre(), user.getPassword(), getAuthorities(user));
    }
    private static Set<? extends GrantedAuthority> getAuthorities(Usuario retrievedUser) {
        Set<Rol> roles = retrievedUser.getRoles();
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getTipoRol())));
        return authorities;
    }
}
