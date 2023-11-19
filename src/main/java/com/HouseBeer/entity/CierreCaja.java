package com.HouseBeer.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Table(name = "cierreCaja")
@Entity
@Data
public class CierreCaja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pedidos")
    @OneToMany(mappedBy = "idPedido")
    private Set<Pedido> pedidos = new HashSet<>();

    @Column(name = "total")
    private BigDecimal total;

    @OneToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

}
