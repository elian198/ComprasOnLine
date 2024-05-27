package com.HouseBeer.repository;

import com.HouseBeer.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

    @Query(value =
    "SELECT * FROM usuario u " +
    "WHERE u.email LIKE :email", nativeQuery = true)
    public Usuario findByEmail(@Param("email") String email);

    @Query(value =
    "SELECT * FROM usuario u " +
    "WHERE u.nombre LIKE :nombre", nativeQuery = true)
    public Usuario findByName(@Param("nombre") String nombre);

}
