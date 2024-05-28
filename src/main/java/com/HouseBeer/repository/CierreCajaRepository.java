package com.HouseBeer.repository;

import com.HouseBeer.entity.CierreCaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CierreCajaRepository extends JpaRepository<CierreCaja, Long> {
}
