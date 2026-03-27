package com.ubam.StoreOutlet.model.views;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Immutable
@Table(name = "vw_prendas_completas")
public class VwPrendaCompleta {

    @Id
    @Column(name = "PrendaId")
    private Integer prendaId;

    @Column(name = "Prenda_Prenda")
    private String nombre;

    @Column(name = "Genero_Genero")
    private String genero;

    @Column(name = "Temporada_Temporada")
    private String temporada;

    @Column(name = "Coleccion_Coleccion")
    private String coleccion;

    @Column(name = "pDetalle_stock")
    private Integer stock;

    @Column(name = "pDetalle_Precio")
    private Float precio;

    @Column(name = "Color_Color")
    private String color;

    @Column(name = "Talla_Talla")
    private String talla;
}
