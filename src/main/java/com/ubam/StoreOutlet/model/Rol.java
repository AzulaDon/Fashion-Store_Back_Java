package com.ubam.StoreOutlet.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_cat_rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RolId")
    private Integer rolId;

    @Column(name = "Rol_Rol")
    private String rol;
}
