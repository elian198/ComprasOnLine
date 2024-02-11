package com.HouseBeer.service;

import com.HouseBeer.entity.Empresa;
import com.HouseBeer.entity.Socursal;
import com.HouseBeer.excepciones.DuplicateNameException;
import com.HouseBeer.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> findAllEmpresa(){
        return empresaRepository.findAllEmpresa();
    }
    public String saveEmpresa(Empresa empresa) throws DuplicateNameException {
        String errores = "";
        if(empresaRepository.existNameEmpresa(empresa.getNombre()).bitCount() == 1){
           errores += "El nombre " + empresa.getNombre() + " ya existe!!!/n";
        }
        if(empresaRepository.findByRazonSocial(empresa.getRazonSocial()) != null){
          errores  += "La razon Social " + empresa.getRazonSocial() + " ya existe !!,";
        }
       else{
            empresaRepository.save(empresa);
            return "OK";
        }
       return  errores;
    }

    public void deleteEmpresa(Long id){
        empresaRepository.deleteById(id);
    }

    public Empresa findById(Long id){
        return empresaRepository.findById(id).get();
    }

    public Empresa findByName(String name){
        return empresaRepository.findByName(name);
    }

    public void addSocursal(Socursal socursal, Long id){
      Empresa empresa =   empresaRepository.findById(id).get();
      empresa.getSocursales().add(socursal);
      empresaRepository.save(empresa);
    }

}
