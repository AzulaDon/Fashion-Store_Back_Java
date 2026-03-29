package com.ubam.StoreOutlet.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "vw_prendas_coleccion")
public class PrendaColeccionView {

    @Id
    @Column(name = "PrendaId")
    private Integer prendaId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "genero")
    private String genero;

    @Column(name = "temporada")
    private String temporada;

    @Column(name = "prenda_coleccionId")
    private Integer prendaColeccionId;

    @Column(name = "precio")
    private Double precio;
}
