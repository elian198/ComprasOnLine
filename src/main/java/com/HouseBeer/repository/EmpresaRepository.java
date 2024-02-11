package com.HouseBeer.repository;

import com.HouseBeer.entity.Empresa;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query( value = "SELECT * FROM empresa WHERE name = :name", nativeQuery = true)
    public Empresa findByName(@Param("name")String name);

    @Query( value = "SELECT * FROM empresa ORDER BY nombre", nativeQuery = true)
    List<Empresa> findAllEmpresa();
    @Query( value = "SELECT * FROM empresa = :name ", nativeQuery = true)
    Empresa findByNameEmpresa(@Param("name") String name);

    @Query( value = "SELECT COUNT(e.nombre) >0 FROM empresa e  " +
            " WHERE e.nombre = :name", nativeQuery = true)
    BigInteger existNameEmpresa(@Param("name") String name);

    @Query( value = "SELECT * FROM empresa WHERE razon_social = :razonSocial", nativeQuery = true)
    public Empresa findByRazonSocial(@Param("razonSocial")String razonSocial);
}
