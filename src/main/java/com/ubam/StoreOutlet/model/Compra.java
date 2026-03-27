package com.ubam.StoreOutlet.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_ope_compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CompraId")
    private Integer compraId;

    @Column(name = "Compra_Compra")
    private String descripcion;

    @Column(name = "Compra_Total")
    private Float total;

    @Column(name = "Compra_usuarioId")
    private Integer usuarioId;

    @Column(name = "Compra_Activo")
    private Boolean activo;
}
