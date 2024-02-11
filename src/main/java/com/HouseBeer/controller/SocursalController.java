package com.HouseBeer.controller;

import com.HouseBeer.entity.Socursal;
import com.HouseBeer.service.SocursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocursalController {

    @Autowired
    private SocursalService socursalService;

    @GetMapping("/socursal")
    public ResponseEntity<List<Socursal>> findAll(){

        return ResponseEntity.ok(socursalService.findAllSort());
    }

    @PostMapping("/socursal")
    public ResponseEntity<Void> saveSocursal(@RequestBody Socursal socursal){
        System.out.println("POST socursal");
        System.out.println("Socursal: " + socursal);
        socursalService.saveSocursal(socursal);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/socursal/findByEmpresa/{id}")
    public ResponseEntity<Socursal> findByName(@Param("id") Long id){
        return ResponseEntity.ok(socursalService.findByEmpresa(id));
    }
}
