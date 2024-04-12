package com.HouseBeer.repository;

import com.HouseBeer.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

    @Query(value =
    "SELECT * FROM usuario u " +
    "WHERE u.email LIKE ?1", nativeQuery = true)
    public Usuario findByEmail(String email);

    @Query(value =
    "SELECT * FROM usuario u " +
    "WHERE u.nombre LIKE ?1", nativeQuery = true)
    public Usuario findByName(String nombre);

}
