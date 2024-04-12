package com.HouseBeer.controller;

import com.HouseBeer.datos.Datos;
import com.HouseBeer.entity.Empresa;
import com.HouseBeer.entity.Producto;
import com.HouseBeer.entity.Socursal;
import com.HouseBeer.entity.enums.Rubro;
import com.HouseBeer.excepciones.DuplicateNameException;
import com.HouseBeer.repository.EmpresaRepository;
import com.HouseBeer.service.EmpresaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmpresaController.class)
class EmpresaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpresaService empresaService;


    @Test
    void testFindAll() throws Exception {
        when(empresaService.findAllEmpresa()).thenReturn(Datos.EMPRESAS);
        mockMvc.perform(get("/api/empresa").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Matilde"));
    }

    @Test
    void testFindByName() throws Exception {
        when(empresaService.findByName("Matilde")).thenReturn(Datos.EMPRESA);
        mockMvc.perform(get("/api/empresa/findByName")
                        .param("name", "Matilde")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

}