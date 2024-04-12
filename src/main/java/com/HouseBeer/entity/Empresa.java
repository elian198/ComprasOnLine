package com.HouseBeer.entity;

import com.HouseBeer.entity.enums.Rubro;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String razonSocial;
    @Enumerated(EnumType.STRING)
    private Rubro rubro;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<Producto> productos = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<Socursal> socursales = new HashSet<>();

    public Empresa() { }

    public Empresa(Long id, String nombre, String razonSocial, Rubro rubro, Set<Producto> productos, Set<Socursal> socursales) {
        this.id = id;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.rubro = rubro;
        this.productos = productos;
        this.socursales = socursales;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public Set<Socursal> getSocursales() {
        return socursales;
    }

    public void setSocursales(Set<Socursal> socursales) {
        this.socursales = socursales;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    public static class Builder{
        private  Empresa empresa;

        public Builder( ) {
        this.empresa = new Empresa();
        }
            public Builder id(Long id){
            this.empresa.id = id;
            return  this;
           }
            public Builder nombre(String nombre){
             this.empresa.nombre = nombre;
             return  this;
            }
            public Builder razonSocial(String razonSocial){
            this.empresa.razonSocial = razonSocial;
            return  this;
            }
            public Builder rubro(Rubro rubro){
            this.empresa.rubro = rubro;
            return  this;
           }
            public Builder productos(Set<Producto> productos){
            this.empresa.productos = productos;
            return  this;
           }
            public Builder socursales(Set<Socursal> socursales){
            this.empresa.socursales = socursales;
            return  this;
           }

           public Empresa builder(){
            return  this.empresa;
           }
    }
    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", rubro=" + rubro +
                ", productos=" + productos +
                ", socursales=" + socursales +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empresa empresa)) return false;
        return Objects.equals(getId(), empresa.getId()) && Objects.equals(getNombre(), empresa.getNombre()) && Objects.equals(getRazonSocial(), empresa.getRazonSocial()) && getRubro() == empresa.getRubro() && Objects.equals(getProductos(), empresa.getProductos()) && Objects.equals(getSocursales(), empresa.getSocursales());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getRazonSocial(), getRubro(), getProductos(), getSocursales());
    }
}
