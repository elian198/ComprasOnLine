package com.HouseBeer.controller;

import com.HouseBeer.entity.Empresa;
import com.HouseBeer.entity.Producto;
import com.HouseBeer.entity.Socursal;
import com.HouseBeer.entity.enums.Rubro;
import com.HouseBeer.excepciones.DuplicateNameException;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmpresaController.class)
class EmpresaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpresaService empresaService;

    Empresa empresa;
    Set<Socursal> socursals = new HashSet<>();
    Set<Producto> productos = new HashSet<>();
    @BeforeEach
    void setUp() {

        Socursal socursal = new Socursal();
        socursal.setEmpresa(empresa);
        socursal.setDireccion("brazil 123");
        socursals.add(socursal);

        Producto producto = new Producto();
        producto.setEmpresa(empresa);
        producto.setActivo(true);
        producto.setNombre("martillo");
        producto.setDescripcion("marillo de metal");
        producto.setPrecio(new BigDecimal(2300));
        productos.add(producto);

        empresa = new Empresa.Builder()
                .id(2L)
                .nombre("ferreteria")
                .razonSocial("Ferre S.R.L")
                .builder();
    }
    @Test
    public void save() throws DuplicateNameException, Exception {
        Empresa empresa1 = new Empresa.Builder()
                .nombre("ferreteria")
                .razonSocial("Ferre S.R.L")
                .rubro(Rubro.COMERCIO)
                .builder();

        Mockito.when(empresaService.saveEmpresa(empresa1)).thenReturn((empresa));
        mockMvc.perform(post("api/empresa").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "   \"nombre\":\"ferreteria\",\n" +
                        "   \"razonSocial\":\"Ferre S.R.L\",\n" +
                        "   \"rubro\":\"COMERCIO\",\n"

                )).andExpect(status().isOk());
    }

}