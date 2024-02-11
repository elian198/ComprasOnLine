package com.HouseBeer.controller;

import com.HouseBeer.entity.Producto;
import com.HouseBeer.repository.ProductoRepository;
import com.HouseBeer.repository.ProductoRepositoryImpl;
import com.HouseBeer.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoRepositoryImpl productoRepository;

   @GetMapping("/producto")
   public ResponseEntity<List<Producto>> findAllProductos(
           Pageable pageable,
           @RequestParam String where
   ){

       List<Producto> resultado = productoRepository.getByCambio(pageable, where, true);
       Page<Producto> response = new PageImpl<>(resultado, pageable, productoRepository.countFileProductos(where));
       HttpHeaders headers = new HttpHeaders();
       return ResponseEntity.ok().headers(headers).body(response.getContent());
   }

   @PostMapping("/producto")
   public ResponseEntity<Void> crearProducto(@RequestBody Producto producto){
       System.out.println("POST producto");
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

    @GetMapping("/producto/distinctNombre")
    public ResponseEntity<List<String>> findAllDistinctNombre(){
        return  ResponseEntity.ok(productoService.findAllDistinctNombre());
    }
}
