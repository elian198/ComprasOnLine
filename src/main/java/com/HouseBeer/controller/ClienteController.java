package com.HouseBeer.controller;

import com.HouseBeer.entity.Cliente;
import com.HouseBeer.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> findAllClients(){
        return  ResponseEntity.ok(clienteService.findAllCLients());
    }

    @PostMapping("/cliente")
    public ResponseEntity<Void> saveClient(@RequestBody Cliente cliente){
        clienteService.saveClient(cliente);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        clienteService.deleteById(id);
        return  ResponseEntity.ok().build();
    }

    @PostMapping("/cliente/findByEmail")
    public ResponseEntity<Cliente> findByEmail(@PathVariable String email){
        return ResponseEntity.ok(clienteService.findByEmail(email));
    }

    @PostMapping("/cliente/findByName")
    public ResponseEntity<Cliente> findByName(@PathVariable String name){
        return ResponseEntity.ok(clienteService.findByName(name));
    }

    @PostMapping("/cliente/findByPhone")
    public ResponseEntity<Cliente> findByPhone(@PathVariable Integer phone){
        return ResponseEntity.ok(clienteService.findByPhone(phone));
    }

    @PostMapping("/cliente/findByDireccion")
    public ResponseEntity<Cliente> findByDireccion(@PathVariable String direccion){
        return ResponseEntity.ok(clienteService.findByDireccion(direccion));
    }
}
