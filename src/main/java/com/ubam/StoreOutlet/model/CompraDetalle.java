package com.ubam.StoreOutlet.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_ope_compra_detalle")
public class CompraDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cDetalleId")
    private Integer id;

    @Column(name = "cDetalle_compraId")
    private Integer compraId;

    @Column(name = "cDetalle_pDetalleId")
    private Integer pDetalleId;

    @Column(name = "cDetalle_Cantidad")
    private Integer cantidad;

    @Column(name = "cDetalle_CostoUnitario")
    private Float costoUnitario;
}
