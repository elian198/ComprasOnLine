package com.HouseBeer.repository;

import com.HouseBeer.entity.Socursal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SocursalRepositoryTest {

    @Autowired
    private  SocursalRepository socursalRepository;

    @Test
    void findByName() {
        Socursal socursal = socursalRepository.findByDireccion("25 de mayo 103");
        Socursal socursalNull = socursalRepository.findByDireccion("25 de mayo 102");
        assertEquals(socursal.getDireccion(), "25 de mayo 103");
        assertNull(socursalNull);
    }

    @Test
    void findByAllSort() {
        List<Socursal> socursalList = socursalRepository.findByAllSort();
        // assertEquals(socursalList, socursalRepository.findAll().stream().sorted().toList());
    }

    @Test
    void findByEmpresa() {
        List<Socursal> socursales = socursalRepository.findByEmpresa(1L);
        List<Socursal> socursalesNull = socursalRepository.findByEmpresa(2L);
        assertEquals(2, socursales.size());
        assertTrue(socursalesNull.isEmpty());
    }
}