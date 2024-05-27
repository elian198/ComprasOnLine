package com.HouseBeer.repository;

import com.HouseBeer.entity.Producto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.constraints.AssertTrue;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductoRepositoryTest {

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    void findByName() {
        List<Producto> producto = productoRepository.findByName("Pasta Frola");
        assertEquals( true, producto.stream().filter(p -> p.getNombre().equals("Pasta Frola")).findFirst().isPresent());
    }

    @Test
    void findByPrice() {
        Producto producto = productoRepository.findByPrice(new BigDecimal(1200.00));
        assertEquals(producto.getNombre(), "Pasta Frola");
    }

    @Test
    void findByImage() {
    }

    @Test
    void findAlldistinctNombre() {
        List<String> productos = productoRepository.findAlldistinctNombre();
        assertEquals(productos.size(), 3);
    }
}