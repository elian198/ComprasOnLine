package com.HouseBeer.controller;

import com.HouseBeer.entity.Producto;
import com.HouseBeer.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    /*
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
  */
   @PostMapping("/producto")
   @ResponseStatus(OK)
   public ResponseEntity<Void> crearProducto(@RequestBody Producto producto){
       productoService.saveProducto(producto);
       return  ResponseEntity.ok().build();
   }

   @DeleteMapping("/producto/{id}")
   @ResponseStatus(OK)
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
       productoService.deleteById(id);
       return ResponseEntity.ok().build();
   }

   @PostMapping("/producto/agregarFoto")
    public ResponseEntity<Void> agregarFotos(@PathVariable List<String> fotos){

       return  ResponseEntity.ok().build();
   }

    @GetMapping("/producto/distinctNombre")
    @ResponseStatus(OK)
    public List<String> findAllDistinctNombre(){
        return  productoService.findAllDistinctNombre();
    }
}
