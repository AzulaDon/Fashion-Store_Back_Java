package com.ubam.StoreOutlet.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_cat_color")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ColorId")
    private Integer colorId;

    @Column(name = "Color_Color")
    private String color;

    @Column(name = "Color_codigoHexa")
    private String codigoHexa;
}
