package com.bodeguita.ms_proveedor.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorResponse {

    private Long idProveedor;
    private String nombre;
    private String celular;
    private String direccion;
    private String correo;
    private String ruc;
}