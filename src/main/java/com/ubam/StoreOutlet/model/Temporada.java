package com.ubam.StoreOutlet.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_cat_temporada")
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TemporadaId")
    private Integer temporadaId;

    @Column(name = "Temporada_Temporada")
    private String temporada;
}
