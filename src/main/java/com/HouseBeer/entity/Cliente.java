package com.HouseBeer.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "CODIGO_POSTAL")
    private Integer codigoPostal;

    @Column(name = "TELEFONO")
    private Integer telefono;

    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos = new HashSet<>();


}
