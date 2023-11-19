package com.HouseBeer.controller;

import com.HouseBeer.entity.Producto;
import com.HouseBeer.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

   
}
