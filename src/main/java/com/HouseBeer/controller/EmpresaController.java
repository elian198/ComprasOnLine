package com.HouseBeer.controller;

import com.HouseBeer.entity.Empresa;
import com.HouseBeer.excepciones.DuplicateNameException;
import com.HouseBeer.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("api/empresa")
    public ResponseEntity<List<Empresa>> findAll(){
        System.out.println("Get Empresas!!");
        return ResponseEntity.ok(empresaService.findAllEmpresa());
    }
    @PostMapping("api/empresa")
    public ResponseEntity<Empresa> saveEmpresa(@RequestBody Empresa empresa) throws DuplicateNameException {
        return ResponseEntity.ok( empresaService.saveEmpresa(empresa));
    }

    @GetMapping("api/empresa/findByName")
    public ResponseEntity<Empresa> findByName(@RequestParam String name){
        return ResponseEntity.ok(empresaService.findByName(name));
    }

    @DeleteMapping("api/empresa/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id){
        System.out.println("ID: " + id);
        empresaService.deleteEmpresa(id);
        return ResponseEntity.ok().build();
    }
}
