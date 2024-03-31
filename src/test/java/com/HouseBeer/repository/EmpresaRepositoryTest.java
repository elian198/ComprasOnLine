package com.HouseBeer.repository;

import com.HouseBeer.entity.Empresa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmpresaRepositoryTest {

    @Autowired
    private  EmpresaRepository empresaRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    Empresa empresa;
    @BeforeEach
    void setUp() {
        empresa = new Empresa.Builder()
                .nombre("ferreteria")
                .razonSocial("Ferre S.R.L")
                .builder();
        testEntityManager.persist(empresa);
    }

    @Test
    void findByName() {
        Empresa findEmpresa = empresaRepository.findByNameEmpresa("ferreteria");
        assertEquals(findEmpresa.getNombre(), "ferreteria");
    }

    @Test
    void findByRazonSocial() {
    }
}