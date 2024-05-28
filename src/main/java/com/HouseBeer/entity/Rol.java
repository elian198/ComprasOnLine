package com.HouseBeer.entity;

import com.HouseBeer.entity.enums.TipoRol;
import lombok.Data;

import javax.persistence.*;

@Table(name = "rol")
@Entity
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(name = "TIPO_DESCRIPCION")
    @Enumerated(EnumType.STRING)
    private TipoRol tipoRol;

    public Rol() {}

    public Rol(TipoRol tipoRol) {
        this.tipoRol = tipoRol;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public TipoRol getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(TipoRol tipoRol) {
        this.tipoRol = tipoRol;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "idRol=" + idRol +
                ", tipoRol=" + tipoRol +
                '}';
    }
}
