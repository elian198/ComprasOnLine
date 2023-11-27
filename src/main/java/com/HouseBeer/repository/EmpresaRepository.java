package com.HouseBeer.repository;

import com.HouseBeer.entity.Empresa;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query( value = "SELECT * FROM empresa WHERE name = :name", nativeQuery = true)
    public Empresa findByName(@Param("name")String name);

    @Query( value = "SELECT * FROM empresa ORDER BY nombre", nativeQuery = true)
    List<Empresa> findAllEmpresa();
}
