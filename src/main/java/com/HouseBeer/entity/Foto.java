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
    private Long id;

    @Column(name = "NOMBRE_ARCHIVO")
    private String nombreArchivo;

    @ManyToOne()
    private Producto producto;

    public Foto() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Foto{" +
                "id =" + id +
                ", nombreArchivo='" + nombreArchivo + '\'' +
                ", producto=" + producto +
                '}';
    }
}
