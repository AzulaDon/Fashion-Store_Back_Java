package com.ubam.StoreOutlet.DTO;

import lombok.Data;

@Data
public class PrendaConDetalleDTO {
    private String nombre;
    private Integer generoId;
    private Integer temporadaId;
    private Integer coleccionId;
    
    private Integer colorId;
    private Integer tallaId;
    private Float precio;
    private Integer stock;
    private String sku;

}
