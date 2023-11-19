package com.HouseBeer.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "usuario")
@Entity
@Data
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "contraseña" , length = 8)
    private String contaseña;

    @OneToMany(mappedBy = "idRol")
    @Column(name = "ID_ROL")
    private Set<Rol> roles = new HashSet<>();

}
