package com.HouseBeer.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cliente")
@Data
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCliente;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "CODIGO_POSTAL")
    private Integer codigoPostal;

    @Column(name = "TELEFONO")
    private Integer telefono;

    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;


}
