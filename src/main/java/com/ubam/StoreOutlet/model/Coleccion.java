package com.ubam.StoreOutlet.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_cat_coleccion")
public class Coleccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ColeccionId")
    private Integer coleccionId;

    @Column(name = "Coleccion_Coleccion")
    private String coleccion;
}
