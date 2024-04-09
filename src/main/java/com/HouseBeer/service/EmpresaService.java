package com.HouseBeer.service;

import com.HouseBeer.entity.Empresa;
import com.HouseBeer.entity.Socursal;
import com.HouseBeer.excepciones.DuplicateNameException;
import com.HouseBeer.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> findAllEmpresa(){
        return empresaRepository.findAllEmpresa();
    }
    public Empresa saveEmpresa(Empresa empresa) throws DuplicateNameException {
       if(empresaRepository.findByName(empresa.getNombre()).isPresent() ||
          empresaRepository.findByRazonSocial(empresa.getRazonSocial()).isPresent())
          throw new DuplicateNameException("El nombre ya existe");

       return empresaRepository.save(empresa);
    }

    public boolean deleteEmpresa(Long id){
        if(id == null) throw  new IllegalArgumentException("No puede ser Null");
      return (empresaRepository.deleteByIdEmpresa(id));
    }

    public Empresa findById(Long id){
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.orElseThrow(IllegalArgumentException::new);
    }

    public Empresa findByName(String name){
        if(name == null){throw new IllegalArgumentException("No se puede enviar Null!!");}
        return empresaRepository.findByName("Matilde").orElse(null);
    }

    public void addSocursal(Socursal socursal, Long id){
      Empresa empresa =   empresaRepository.findById(id).get();
      empresa.getSocursales().add(socursal);
      empresaRepository.save(empresa);
    }

}
