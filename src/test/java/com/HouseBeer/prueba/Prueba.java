package com.HouseBeer.prueba;

import com.HouseBeer.datos.Datos;
import com.HouseBeer.entity.Empresa;
import com.HouseBeer.entity.enums.Rubro;
import com.HouseBeer.repository.EmpresaRepository;
import com.HouseBeer.service.EmpresaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // usamos para poder usar las anotaciones de mock
public class Prueba {

    @Mock
    EmpresaRepository empresaRepository;

    @InjectMocks
    EmpresaService empresaService;

    Empresa empresa;


    @BeforeEach
    void setUp() {
        empresa = new Empresa.Builder()
                .nombre("Matilde")
                .id(3L)
                .rubro(Rubro.GASTRONOMICO)
                .razonSocial("Matilde S.R")
                .builder();
    }


    // spy permite acceder a los metodos reales
    @Test
    void testSpy(){
        EmpresaRepository empresaRepository1 = spy(EmpresaRepository.class);
    }

    @Test // verifica el orden de invocacion
    void testOrdenInvocacion(){
        empresaService.findById(3L);
        empresaService.findById(2L);
        InOrder inOrder = inOrder(empresaRepository);
        inOrder.verify(empresaRepository).findById(3L);
        inOrder.verify(empresaRepository).findById(2L);
    }

    @Test // comprueba las veces que se invoco a un metodo
    void cantidadinvocaciones(){
        empresaService.findByName("Matilde");
        verify(empresaRepository, times(1)).findByName("Matilde");
        verify(empresaRepository, atLeast(1)).findByName("Matilde"); // como minimo se ejecuta 1 vez
        verify(empresaRepository, atLeastOnce()).findByName("Matilde"); // lo mismoque atLest
        verify(empresaRepository, atMost(1)).findByName("Matilde"); // como maximo
    }

    @Test
    void testInvocaciones2(){
        empresaService.findByName("Matilde");
        verify(empresaRepository, never()).findById(3L);
    }
}
