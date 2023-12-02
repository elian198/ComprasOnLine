package com.HouseBeer.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "socursal")
public class Socursal {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private  Long id;

    private  String direccion;
    private Integer telefono;
    private LocalDateTime fechaAlta;

    @ManyToOne()
    private Empresa empresa;
   @OneToOne()
   private  Zona zona;

    public Socursal() { }

    public Socursal(Long id, String direccion, Integer telefono, LocalDateTime fechaAlta, Empresa empresa) {
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaAlta = fechaAlta;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Socursal{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", fechaAlta=" + fechaAlta +
                ", empresa=" + empresa +
                '}';
    }
}
