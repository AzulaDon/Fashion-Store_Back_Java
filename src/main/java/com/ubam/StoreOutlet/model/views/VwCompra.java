package com.ubam.StoreOutlet.model.views;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Immutable
@Table(name = "vw_compras")
public class VwCompra {

    @Id
    @Column(name = "CompraId")
    private Integer compraId;

    @Column(name = "Usuario_Correo")
    private String correoUsuario;

    @Column(name = "Compra_Total")
    private Float total;
}
