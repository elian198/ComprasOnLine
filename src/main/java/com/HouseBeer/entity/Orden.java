package com.HouseBeer.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;

    @OneToOne()
    private Producto producto;

    @ManyToOne()
    private Pedido pedido;

}
