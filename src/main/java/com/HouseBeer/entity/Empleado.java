package com.HouseBeer.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "empleado")
@Data
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String apellido;
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @ManyToOne()
    private Socursal socursal;

}
