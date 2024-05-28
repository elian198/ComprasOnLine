package com.HouseBeer.service;

import com.HouseBeer.entity.Foto;
import com.HouseBeer.entity.Producto;
import com.HouseBeer.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAllProductos(){
      return productoRepository.findAll(Sort.by("nombre"));
    }

    public void saveProducto(Producto producto){
        productoRepository.save(producto);
    }

    public void deleteById(Long id){
        productoRepository.deleteById(id);
    }

    public void addImage(Long id, List<Foto> foto){
      Optional<Producto>  producto = productoRepository.findById(id);
      producto.get().getFotos().addAll(foto);
      productoRepository.save(producto.get());
    }

    public List<Producto> findByName(String name){
        return  productoRepository.findByName(name);
    }

    public  List<String> findAllDistinctNombre(){
        return  productoRepository.findAlldistinctNombre();
    }

}
