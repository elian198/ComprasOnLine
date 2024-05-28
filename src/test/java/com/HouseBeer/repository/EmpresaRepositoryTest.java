package com.HouseBeer.repository;

import com.HouseBeer.datos.Datos;
import com.HouseBeer.entity.Empresa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class EmpresaRepositoryTest {

    @Autowired
    EmpresaRepository empresaRepository;

    @Test
    void testFindByName(){
        Optional<Empresa> empresa =  empresaRepository.findByName("Matilde");
        assertTrue(empresa.isPresent());
    }
    @Test
    void testFindById(){
        Optional<Empresa> empresa = empresaRepository.findById(3L);
        assertTrue(empresa.isPresent());
    }
    @Test
    void testFindByRazonSocial(){
        Optional<Empresa> empresa = empresaRepository.findByRazonSocial("Havanna S.R");
        assertTrue(empresa.isPresent());
    }
    @Test
    void testFindAllOrderName(){
        List<Empresa> empresas =  empresaRepository.findAllEmpresa();
        List<Empresa> empresas1 = empresaRepository.findAll().stream().sorted(Comparator.comparing(Empresa::getNombre)).collect(Collectors.toList());
        assertEquals(empresas, empresas1);
    }

    @Test
    void testSaveEmpresa(){
        empresaRepository.save(Datos.EMPRESA3);
        Optional<Empresa> empresa =  empresaRepository.findByName("YPF");
        assertTrue(empresa.isPresent());
    }
}