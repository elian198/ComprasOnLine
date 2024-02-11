package com.HouseBeer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "socursal")
public class Socursal {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private  Long id;

    private  String direccion;
    private Integer telefono;
    private LocalDateTime fechaAlta;

    private String provincia;

    @JsonBackReference
    @ManyToOne()
    private Empresa empresa;
    @JsonIgnore
    @OneToOne()
    private Zona zona;

    @OneToMany(mappedBy = "socursal")
    private Set<Empleado> empleados = new HashSet<>();

    public Socursal() { }

    public Socursal(Long id, String direccion, Integer telefono, LocalDateTime fechaAlta, Empresa empresa, String provincia) {
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaAlta = fechaAlta;
        this.empresa = empresa;
        this.provincia = provincia;
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

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Socursal{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", fechaAlta=" + fechaAlta +
                ", provincia='" + provincia + '\'' +
                ", empresa=" + empresa +
                ", zona=" + zona +
                ", empleados=" + empleados +
                '}';
    }
}
