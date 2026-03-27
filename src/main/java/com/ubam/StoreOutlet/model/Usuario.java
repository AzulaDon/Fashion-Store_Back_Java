package com.ubam.StoreOutlet.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_ope_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsuarioId")
    private Integer usuarioId;

    @Column(name = "Usuario_rolId")
    private Integer rolId;

    @Column(name = "Usuario_Telefono")
    private String telefono;

    @Column(name = "Usuario_Correo")
    private String correo;

    @Column(name = "Usuario_Clave")
    private String clave;

    @Column(name = "Usuario_Activo")
    private Boolean activo;
}
