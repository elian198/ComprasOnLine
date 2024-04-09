package com.HouseBeer;

import com.HouseBeer.datos.Datos;
import com.HouseBeer.entity.Empresa;
import com.HouseBeer.repository.EmpresaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DataJpaTest
public class IntegracionJpa {

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
     Optional<Empresa> id = empresaRepository.findAll().stream()
             .max(Comparator.comparing(Empresa::getId));
      empresaRepository.save(Datos.EMPRESA3);
      Optional<Empresa> empresa =  empresaRepository.findByName("YPF");
      assertTrue(empresa.isPresent());
      assertEquals(empresa.get().getId(), id.get().getId() + 1 );
    }
    @Test
    void testDelete(){
        List<Empresa> empresas = empresaRepository.findAll();
        empresaRepository.deleteById(3L);
        Optional<Empresa> empresa = empresaRepository.findById(3L);
        assertFalse(empresa.isPresent());

        assertThrows(EmptyResultDataAccessException.class, ()->{
                empresaRepository.deleteById(5L);
        });

      assertEquals(empresas.size() -1 , empresaRepository.findAll().size());
    }


}
