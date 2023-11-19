package com.HouseBeer.service;

import com.HouseBeer.entity.Foto;
import com.HouseBeer.entity.Producto;
import com.HouseBeer.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAllProductos(){
      return productoRepository.findAll();
    }

    public void saveProducto(Producto producto){
        productoRepository.save(producto);
    }

    public void deleteById(Long id){
        productoRepository.deleteById(id);
    }

    public void saveFoto(Long id, Foto foto){
      Optional<Producto>  producto = productoRepository.findById(id);
      productoRepository.save(producto.get());
    }
}
