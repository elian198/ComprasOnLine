package com.HouseBeer.repository;

import com.HouseBeer.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query( value = "SELECT * FROM empresa WHERE nombre = :name", nativeQuery = true)
    Optional<Empresa>findByName(@Param("name")String name);

    @Query( value = "SELECT * FROM empresa WHERE id = :id", nativeQuery = true)
    Optional<Empresa> findById(@Param("id")Long id);

    @Query( value = "SELECT * FROM empresa ORDER BY nombre", nativeQuery = true)
    List<Empresa> findAllEmpresa();

    @Query( value = "SELECT COUNT(e.nombre) >0 FROM empresa e  " +
            " WHERE e.nombre = :name", nativeQuery = true)
    BigInteger existNameEmpresa(@Param("name") String name);

    @Query( value = "SELECT * FROM empresa WHERE razon_social = :razonSocial", nativeQuery = true)
    Optional<Empresa> findByRazonSocial(@Param("razonSocial")String razonSocial);

    @Query( value = "DELETE FROM empresa WHERE id  :id", nativeQuery = true)
    Boolean deleteByIdEmpresa(@Param("id") Long id);
}
