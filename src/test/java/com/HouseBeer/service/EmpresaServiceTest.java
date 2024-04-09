package com.HouseBeer.service;

import com.HouseBeer.datos.Datos;
import com.HouseBeer.entity.Empresa;
import com.HouseBeer.entity.enums.Rubro;
import com.HouseBeer.excepciones.DuplicateNameException;
import com.HouseBeer.repository.EmpresaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.will;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // usamos para poder usar las anotaciones de mock
@MockitoSettings(strictness = Strictness.LENIENT)
class EmpresaServiceTest {

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

    @Test
    void findAllEmpresa() {

    }

    @Test
    void saveEmpresa() throws DuplicateNameException {
        when(empresaRepository.findByName("Matilde")).thenReturn(Optional.ofNullable(Datos.EMPRESA));
        when(empresaRepository.findByRazonSocial("Matilde S.R")).thenReturn(Optional.ofNullable(Datos.EMPRESA));
        empresaService.saveEmpresa(Datos.EMPRESA2);
        verify(empresaRepository).findByName("Havanna");
        verify(empresaRepository.findByRazonSocial("Havanna S.R"));

        Empresa respuesta = empresaService.saveEmpresa(Datos.EMPRESA2);
        Exception exception = assertThrows(DuplicateNameException.class, () -> {
            empresaService.findByName("Havanna");
        });

        assertEquals(DuplicateNameException.class, exception.getClass());

    }
    @Test
    void deleteEmpresa() {
        when(empresaRepository.findAll()).thenReturn(Datos.EMPRESAS);
        when(empresaRepository.deleteByIdEmpresa(3L)).thenReturn(true);
        empresaService.saveEmpresa(this.empresa);
        Boolean isDelete = empresaService.deleteEmpresa(3L);
        assertEquals(true, isDelete);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            empresaService.deleteEmpresa(null);
        });
        assertEquals(IllegalArgumentException.class, exception.getClass());

    }

    @Test
    void findById() {
        when(empresaRepository.findById(1L)).thenReturn(Optional.ofNullable(Datos.EMPRESA2));
        // sirve para llamar el metodo real del repositorio
        // doCallRealMethod().when(empresaRepository.findById(anyLong()));
       Empresa empresa1 =  empresaService.findById(1L);
       assertEquals(empresa1.getNombre(), "Havanna");
       Exception exception = assertThrows(IllegalArgumentException.class, ()->{
           empresaService.findById(null);
       });
       assertEquals(exception.getClass(), IllegalArgumentException.class);
    }

    @Test
    void findByName() {
      Exception exception = assertThrows(IllegalArgumentException.class, ()->{
       empresaService.findByName(null);
      });
      assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @Test
    void addSocursal() {
    }


}