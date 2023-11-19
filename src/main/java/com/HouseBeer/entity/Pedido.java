package com.HouseBeer.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table(name = "factura")
@Entity
@Data
@Builder
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPedido;

    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;


    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cliente cliente;

    @OneToMany(mappedBy = "idProducto")
    @Column(name = "ID_PRODUCTO")
    private Set<Producto> productos = new HashSet<>();

    @Column(name = "IMPORTE_TOTAL")
    private BigDecimal importeTotal;



}
