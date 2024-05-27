package com.HouseBeer.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table(name = "pedido")
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @ManyToOne()
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private Set<Orden> orden = new HashSet<>();

    @Column(name = "IMPORTE_TOTAL")
    private BigDecimal importeTotal;

    private Boolean estado;

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


    public Set<Orden> getOrden() {
        return orden;
    }

    public void setOrden(Set<Orden> orden) {
        this.orden = orden;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
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
                ", orden=" + orden +
                ", importeTotal=" + importeTotal +
                ", estado=" + estado +
                '}';
    }
}
