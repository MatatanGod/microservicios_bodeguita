package com.bodeguita.ms_detalle_venta.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponse {

    private Integer idProducto;
    private String nombreProducto;
    private BigDecimal precioVenta;
    private Integer cantidad;
}