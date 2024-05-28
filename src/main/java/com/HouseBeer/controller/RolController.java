package com.HouseBeer.controller;

import com.HouseBeer.entity.Rol;
import com.HouseBeer.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/roles")
    public ResponseEntity<Iterable<Rol>> findAllRol(){
        return  ResponseEntity.ok().body(rolService.findAllRol());
    }

    @PostMapping("/saveRol")
    public ResponseEntity saveRol(@RequestBody Rol rol){
        rolService.saveRol(rol);
        return ResponseEntity.ok().build();
    }
}
