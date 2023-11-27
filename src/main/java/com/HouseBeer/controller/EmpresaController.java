package com.HouseBeer.controller;

import com.HouseBeer.entity.Empresa;
import com.HouseBeer.repository.EmpresaRepository;
import com.HouseBeer.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/")
    public ResponseEntity<List<Empresa>> findAll(){
        return ResponseEntity.ok(empresaService.findAllEmpresa());
    }

    @PostMapping("/")
    public ResponseEntity<Void> saveEmpresa(@RequestBody Empresa empresa){
        empresaService.saveEmpresa(empresa);
        return ResponseEntity.ok().build();
    }

    @GetMapping("findByName")
    public ResponseEntity<Empresa> findByName(@RequestParam String name){
        return ResponseEntity.ok(empresaService.findByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresa(@Param("id") Long id){
        empresaService.deleteEmpresa(id);
        return ResponseEntity.ok().build();
    }
}
