package com.HouseBeer.service;

import com.HouseBeer.entity.Empresa;
import com.HouseBeer.entity.Socursal;
import com.HouseBeer.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> findAllEmpresa(){
        return empresaRepository.findAllEmpresa();
    }
    public void saveEmpresa(Empresa empresa){
        empresaRepository.save(empresa);
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
