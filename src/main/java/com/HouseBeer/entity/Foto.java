package com.HouseBeer.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table( name = "foto")
@Entity
@Data
public class Foto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFoto;

    @Column(name = "NOMBRE_ARCHIVO")
    private String nombreArchivo;
}
