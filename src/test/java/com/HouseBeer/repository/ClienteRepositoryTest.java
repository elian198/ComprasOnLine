package com.HouseBeer.repository;

import com.HouseBeer.entity.Cliente;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClienteRepositoryTest {

    @Autowired
    private  ClienteRepository clienteRepository;

    @Test
    void findByName() {
       List<Cliente> cliente = clienteRepository.findByName("alan");
       assertEquals(cliente.size(), 2);
    }

    @Test
    void findByEmail() {
        List<Cliente> cliente = clienteRepository.findByEmail("Alan@hotmail.com");
        assertEquals(cliente.size(), 2);
    }

    @Test
    void findByPhone() {
        Cliente cliente = clienteRepository.findByPhone(1156557788);
        assertEquals(cliente.getNombre(), "alan");
    }

    @Test
    void findByDireccion() {
        Cliente cliente = clienteRepository.findByDireccion("La paz");
        assertEquals(cliente.getApellido(), "Perez");
    }
}