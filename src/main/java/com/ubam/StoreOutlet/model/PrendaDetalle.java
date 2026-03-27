package com.ubam.StoreOutlet.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_ope_prenda_detalle")
public class PrendaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pDetalle_Id")
    private Integer id;

    @Column(name = "pDetalle_prendaId")
    private Integer prendaId;

    @Column(name = "pDetalle_colorId")
    private Integer colorId;

    @Column(name = "pDetalle_tallaId")
    private Integer tallaId;

    @Column(name = "pDetalle_stock")
    private Integer stock;

    @Column(name = "pDetalle_SKU")
    private String sku;

    @Column(name = "pDetalle_Precio")
    private Float precio;
}
