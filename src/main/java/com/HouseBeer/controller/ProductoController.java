package com.HouseBeer.controller;

import com.HouseBeer.entity.Producto;
import com.HouseBeer.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

   @GetMapping("/producto")
   public ResponseEntity<List<Producto>> findAllProductos() {
       return  ResponseEntity.ok(productoService.findAllProductos());
   }

   @PostMapping("/producto")
   public ResponseEntity<Void> crearProducto(@RequestBody Producto producto){
       productoService.saveProducto(producto);
       return  ResponseEntity.ok().build();
   }

   @DeleteMapping("/producto/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
       productoService.deleteById(id);
       return ResponseEntity.ok().build();
   }

   @PostMapping("/producto/agregarFoto")
    public ResponseEntity<Void> agregarFotos(@PathVariable List<String> fotos){

       return  ResponseEntity.ok().build();
   }
}
