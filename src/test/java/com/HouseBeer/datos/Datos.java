package com.HouseBeer.datos;

import com.HouseBeer.entity.Empresa;
import com.HouseBeer.entity.Producto;
import com.HouseBeer.entity.Socursal;
import com.HouseBeer.entity.enums.Rubro;

import java.lang.reflect.Array;
import java.util.*;

public class Datos {
    public final static List<Empresa> EMPRESAS =  Arrays.asList(
           new Empresa.Builder().nombre("Matilde").id(3L).rubro(Rubro.GASTRONOMICO).razonSocial("Matilde S.R")
           .builder(),
            new Empresa.Builder().nombre("Havanna").id(1L).rubro(Rubro.GASTRONOMICO).razonSocial("Havanna S.R")
            .builder()
    );

    public final static  Empresa  EMPRESA =  new Empresa.Builder()
            .nombre("Matilde")
            .id(3L)
            .rubro(Rubro.GASTRONOMICO)
            .razonSocial("Matilde S.R")
            .builder();

    public final static  Empresa  EMPRESA2 =  new Empresa.Builder()
            .nombre("Havanna")
            .rubro(Rubro.GASTRONOMICO)
            .razonSocial("Havanna S.R")
            .builder();

    public final static  Empresa  EMPRESA3 =  new Empresa.Builder()
            .nombre("YPF")
            .rubro(Rubro.COMERCIO)
            .razonSocial("YPF S.R")
            .builder();
}
