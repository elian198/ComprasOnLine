package com.HouseBeer.entity;

import com.HouseBeer.entity.enums.TipoRol;
import lombok.Data;

import javax.persistence.*;

@Table(name = "rol")
@Entity
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRol;

    @Column(name = "TIPO_DESCRIPCION", unique = true)
    @Enumerated(EnumType.STRING)
    private TipoRol tipoRol;

}
