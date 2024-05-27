package com.HouseBeer.service;

import com.HouseBeer.entity.Socursal;
import com.HouseBeer.repository.SocursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocursalService {

    @Autowired
    private SocursalRepository socursalRepository;

    public void saveSocursal(Socursal socursal){
        socursalRepository.save(socursal);
    }

    public List<Socursal> findAllSort(){
        return  socursalRepository.findByAllSort();
    }

    public List<Socursal> findByEmpresa(Long id){
        return socursalRepository.findByEmpresa(id);
    }

    public Socursal findByDireccion(String name){
        return socursalRepository.findByDireccion(name);
    }
}
