package com.HouseBeer.service;

import com.HouseBeer.entity.Pedido;
import com.HouseBeer.entity.Rol;
import com.HouseBeer.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public Iterable<Rol> findAllRol(){
        return rolRepository.findAll();
    }

    public void saveRol(Rol rol){

        rolRepository.save(rol);
    }

    public void deleteById(Long id){
        rolRepository.deleteById(id);
    }
}
