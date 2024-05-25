package com.HouseBeer.controller;

import com.HouseBeer.datos.Datos;
import com.HouseBeer.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(ProductoController.class)
class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService  productoService;
    @Test
    void findAllProductos() {
        when(productoService.findAllProductos()).thenReturn(Datos.PRODUCTOS);
    }

    @Test
    void crearProducto() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void agregarFotos() {
    }

    @Test
    void findAllDistinctNombre() {
    }
}