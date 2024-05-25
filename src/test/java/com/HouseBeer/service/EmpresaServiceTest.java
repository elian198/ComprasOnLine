package com.HouseBeer.service;

import com.HouseBeer.datos.Datos;
import com.HouseBeer.entity.Empresa;
import com.HouseBeer.repository.EmpresaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmpresaServiceTest {

    @InjectMocks
    EmpresaService empresaService;

    @Mock
    EmpresaRepository empresaRepository;

    @Test
    void findAllEmpresa() {
    }

    @Test
    void saveEmpresa() {
    }

    @Test
    void deleteEmpresa() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    when(empresaRepository.findByName("Matilde")).thenReturn(Optional.ofNullable(Datos.EMPRESA));
        Empresa empresa = empresaService.findByName("Matilde");
        assertEquals(empresa.getNombre(), "Matilde");
    }

    @Test
    void addSocursal() {
    }

    @Test
    void testFindAllEmpresa() {
    }

    @Test
    void testSaveEmpresa() {
    }

    @Test
    void testDeleteEmpresa() {
    }

    @Test
    void testFindById() {
    }

    @Test
    void testFindByName() {
    }

    @Test
    void testAddSocursal() {
    }
}