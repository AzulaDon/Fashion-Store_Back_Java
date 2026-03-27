package com.ubam.StoreOutlet.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_ope_prenda")
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PrendaId")
    private Integer prendaId;

    @Column(name = "Prenda_Prenda")
    private String nombre;

    @Column(name = "Prenda_generoId")
    private Integer generoId;

    @Column(name = "Prenda_temporadaId")
    private Integer temporadaId;

    @Column(name = "Prenda_coleccionId")
    private Integer coleccionId;

    @Column(name = "Prenda_Activo")
    private Boolean activo;
}
