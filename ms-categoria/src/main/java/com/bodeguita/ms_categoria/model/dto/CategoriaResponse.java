package com.bodeguita.ms_categoria.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaResponse {

    private Long idCategoria;
    private String nombreCategoria;
    private String descripcion;
    private LocalDateTime fechaCreacion;
}