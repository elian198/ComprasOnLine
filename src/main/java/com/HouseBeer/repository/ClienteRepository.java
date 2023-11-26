package com.HouseBeer.repository;

import com.HouseBeer.entity.Cliente;
import com.HouseBeer.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Query(value =
    "SELECT * FROM cliente c " +
    "WHERE c.nombre LIKE ?1", nativeQuery = true)
    public Cliente findByName(String name);

    @Query(value =
    "SELECT * FROM cliente c " +
    "WHERE c.email LIKE ?1", nativeQuery = true)
    public Cliente findByEmail(String email);

    @Query(value =
    "SELECT * FROM cliente c " +
    "WHERE c.telefono LIKE ?1", nativeQuery = true)
    public Cliente findByPhone(Integer telefono);

    @Query(value =
    "SELECT * FROM cliente c " +
    "WHERE c.direccion LIKE ?1", nativeQuery = true)
    public Cliente findByDireccion(String direccion);

}
