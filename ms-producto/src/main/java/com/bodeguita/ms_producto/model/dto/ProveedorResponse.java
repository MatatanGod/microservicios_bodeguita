package com.bodeguita.ms_producto.model.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProveedorResponse {
    private Integer idProveedor;
    private String nombre;
    private String ruc;
}