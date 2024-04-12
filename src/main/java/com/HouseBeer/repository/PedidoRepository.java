package com.HouseBeer.repository;

import com.HouseBeer.entity.Pedido;
import com.HouseBeer.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value =
     "SELECT * FROM pedido p " +
     "WHERE p.fecha_creacion LIKE ?1", nativeQuery = true)
    public Pedido findByDate(String fecha);

}
