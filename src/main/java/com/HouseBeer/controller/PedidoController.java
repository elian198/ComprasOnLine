package com.HouseBeer.controller;

import com.HouseBeer.entity.Pedido;
import com.HouseBeer.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> findAllPedidos(){
        return ResponseEntity.ok(pedidoService.findAllPedidos());
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Void> crearPedido(@RequestBody Pedido pedido){
        pedidoService.savePedido(pedido);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/pedidos/buscarPorFecha")
    public ResponseEntity<Pedido> buscarPorFecha(@PathVariable String fecha){
        return ResponseEntity.ok(pedidoService.findByDate(fecha));
    }


}
