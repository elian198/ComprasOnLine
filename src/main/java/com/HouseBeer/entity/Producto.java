package com.HouseBeer.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Table(name = "producto")
@Entity
@Data
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProducto;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO")
    private BigDecimal precio;

    @OneToMany(mappedBy = "idFoto")
    @Column(name = "ID_FOTO")
    private Set<Foto> fotos = new HashSet<>();

}
