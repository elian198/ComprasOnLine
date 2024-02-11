package com.HouseBeer.repository;

import com.HouseBeer.entity.Producto;
import com.HouseBeer.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long>  {
    @Query(value =
    "SELECT * FROM producto p " +
    "WHERE p.nombre LIKE ?1", nativeQuery = true)
    public List<Producto> findByName(String name);

    @Query(value =
    "SELECT * FROM producto p " +
    "WHERE p.precio LIKE ?1", nativeQuery = true)
    public Producto findByPrice(BigDecimal precio);

    @Query(value =
    "SELECT * FROM producto p " +
    "WHERE p.id_foto LIKE ?1", nativeQuery = true)
    public Producto findByImage(String imagen);

    @Query(value =
            "SELECT DISTINCT p.nombre FROM producto p " +
            "ORDER BY p.nombre", nativeQuery = true)
    public  List<String> findAlldistinctNombre();


}
