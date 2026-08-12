package com.bodeguita.ms_producto.model.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CategoriaResponse {
    private Integer idCategoria;
    private String nombreCategoria;
}