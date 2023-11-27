package com.HouseBeer.repository;

import com.HouseBeer.entity.Empresa;
import com.HouseBeer.entity.Socursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SocursalRepository extends JpaRepository<Socursal, Long> {

    @Query(value = "SELECT * FROM socursal WHERE nombre = :name", nativeQuery = true)
    public Socursal findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM socursal ORDER BY nombre", nativeQuery = true)
    public List<Socursal> findByAllSort();

    @Query(value = "SELECT * FROM socursal WHERE empresa_id = :id", nativeQuery = true)
    public Socursal findByEmpresa(@Param("id") Long id);
}
