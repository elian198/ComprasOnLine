package com.HouseBeer.entity;

import com.HouseBeer.entity.enums.Rubro;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String razonSocial;
    @Enumerated(EnumType.STRING)
    private Rubro rubro;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Set<Socursal> socursales = new HashSet<>();

    public Empresa() {}

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

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", rubro=" + rubro +
                ", socursales=" + socursales +
                '}';
    }
}
