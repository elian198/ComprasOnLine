package com.HouseBeer.repository;

import com.HouseBeer.entity.Producto;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Repository
public class ProductoRepositoryImpl {

    @PersistenceContext
    EntityManager entityManager;

    public List<Producto> getByCambio(Pageable pageable, String where, Boolean conLimit) {
        String query =
                "SELECT * FROM producto p " +
                        where +
                        " ORDER BY p.nombre " +
                        (
                                conLimit
                                        ? " LIMIT " + ((int) pageable.getPageSize() * (int) pageable.getPageNumber()) + ", " + pageable.getPageSize() + ";"
                                        : ""
                        );

        // Obtengo la respuesta de la bd
        Query q = entityManager.createNativeQuery(query, Producto.class);
        return q.getResultList();
    }

    public Integer countFileProductos(String where) {
        String queryTotal = "SELECT COUNT(*) FROM producto p " + where;

        Query qTotal = entityManager.createNativeQuery(queryTotal);
        BigInteger total = new BigInteger(qTotal.getSingleResult().toString());
        return total.intValue();
    }
}
