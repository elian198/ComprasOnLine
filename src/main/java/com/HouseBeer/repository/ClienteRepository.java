package com.HouseBeer.repository;

import com.HouseBeer.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Query(value =
    "SELECT * FROM cliente  " +
    "WHERE nombre LIKE :nombre%", nativeQuery = true)
    public List<Cliente> findByName(@Param("nombre") String name);

    @Query(value =
    "SELECT * FROM cliente c " +
    "WHERE c.email LIKE ?1%", nativeQuery = true)
    List<Cliente> findByEmail(String email);

    @Query(value =
    "SELECT * FROM cliente c " +
    "WHERE c.telefono LIKE ?1", nativeQuery = true)
    public Cliente findByPhone(Integer telefono);

    @Query(value =
    "SELECT * FROM cliente c " +
    "WHERE c.direccion LIKE ?1", nativeQuery = true)
    public Cliente findByDireccion(String direccion);

}
