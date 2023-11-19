package com.HouseBeer.service;

import com.HouseBeer.entity.Cliente;
import com.HouseBeer.entity.Producto;
import com.HouseBeer.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAllProductos(){
        return clienteRepository.findAll();
    }

    public void saveProducto(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }
}
