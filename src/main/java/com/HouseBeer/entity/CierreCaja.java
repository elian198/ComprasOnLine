package com.HouseBeer.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Table(name = "cierreCaja")
@Entity
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

    public CierreCaja() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
