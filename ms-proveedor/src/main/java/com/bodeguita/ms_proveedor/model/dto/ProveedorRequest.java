package com.bodeguita.ms_proveedor.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorRequest {

    private String nombre;
    private String celular;
    private String direccion;
    private String correo;
    private String ruc;
}