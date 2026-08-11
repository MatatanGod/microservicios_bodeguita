package com.bodeguita.ms_detalle_venta.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaRequest {

    private Long idVenta;
    private Integer idProducto;
    private Integer cantidad;
}