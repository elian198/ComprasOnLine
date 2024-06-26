package com.HouseBeer.service;

import com.HouseBeer.entity.Cliente;
import com.HouseBeer.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> findAllCLients(){
        return clienteRepository.findAll();
    }

    public void saveClient(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }

    public List<Cliente> findByEmail(String email){
        return  clienteRepository.findByEmail(email);
    }

    public Cliente findByPhone(Integer phone){
        return clienteRepository.findByPhone(phone);
    }

    public List<Cliente> findByName(String name){
        return clienteRepository.findByName(name);
    }

    public Cliente findByDireccion(String direccion){
        return  clienteRepository.findByDireccion(direccion);
    }
}
