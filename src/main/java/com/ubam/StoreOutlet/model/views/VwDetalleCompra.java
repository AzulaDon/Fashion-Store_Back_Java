package com.ubam.StoreOutlet.model.views;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Immutable
@Table(name = "vw_detalle_compra")
public class VwDetalleCompra {

    @Id
    @Column(name = "cDetalleId")
    private Integer detalleId;

    @Column(name = "CompraId")
    private Integer compraId;

    @Column(name = "Prenda_Prenda")
    private String prenda;

    @Column(name = "cDetalle_Cantidad")
    private Integer cantidad;

    @Column(name = "cDetalle_CostoUnitario")
    private Float costoUnitario;
}
