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

    @ManyToOne()
    private Producto producto;

    public Foto() {}

    public Long getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Long idFoto) {
        this.idFoto = idFoto;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
}
