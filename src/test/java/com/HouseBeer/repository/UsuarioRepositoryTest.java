package com.HouseBeer.repository;

import com.HouseBeer.entity.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByEmail() {
        Usuario usuario = usuarioRepository.findByEmail("jose@gmail.com");
        assertEquals("Perez", usuario.getNombre());
    }

    @Test
    void findByName() {
        Usuario usuario = usuarioRepository.findByName("alan");
        System.out.println(usuario.getNombre());
        assertEquals(usuario.getNombre(), "alan");
    }

    @Test
    void findByAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        assertEquals(usuarios.size(), 3);
    }
}