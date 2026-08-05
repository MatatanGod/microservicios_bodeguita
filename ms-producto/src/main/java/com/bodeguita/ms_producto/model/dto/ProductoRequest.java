package com.bodeguita.producto.model.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProductoRequest {
    private String nombreProducto;
    private Integer idCategoria;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private Integer cantidad;
    private String descripcion;
    private String codigoBarras;
    private Integer idProveedor;
}