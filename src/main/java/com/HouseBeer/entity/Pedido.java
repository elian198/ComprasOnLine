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

    public Pedido() {}

    public Pedido(Long idPedido, LocalDateTime fechaCreacion, Cliente cliente, BigDecimal importeTotal) {
        this.idPedido = idPedido;
        this.fechaCreacion = fechaCreacion;
        this.cliente = cliente;
        this.importeTotal = importeTotal;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", fechaCreacion=" + fechaCreacion +
                ", cliente=" + cliente +
                ", productos=" + productos +
                ", importeTotal=" + importeTotal +
                '}';
    }
}
