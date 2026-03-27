package com.ubam.StoreOutlet.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tbl_ope_promocion")
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PromocionId")
    private Integer promocionId;

    @Column(name = "Promocion_descuentoPorcentaje")
    private BigDecimal descuentoPorcentaje;

    @Column(name = "Promocion_fechaInicioPromo")
    private LocalDate fechaInicio;

    @Column(name = "Promocion_fechaFinPromo")
    private LocalDate fechaFin;

    @Column(name = "Promocion_Activo")
    private Boolean activo;
}
