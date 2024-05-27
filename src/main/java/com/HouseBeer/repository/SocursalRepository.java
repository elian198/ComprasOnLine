package com.HouseBeer.repository;

import com.HouseBeer.entity.Empresa;
import com.HouseBeer.entity.Socursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocursalRepository extends JpaRepository<Socursal, Long> {

    @Query(value = "SELECT * FROM socursal WHERE direccion = :direccion", nativeQuery = true)
    public Socursal findByDireccion(@Param("direccion") String direccion);

    @Query(value = "SELECT * FROM socursal ORDER BY provincia", nativeQuery = true)
    public List<Socursal> findByAllSort();

    @Query(value = "SELECT * FROM socursal WHERE empresa_id = :id", nativeQuery = true)
    List<Socursal> findByEmpresa(@Param("id") Long id);
}
