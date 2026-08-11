package com.bodeguita.producto.model.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductoResponse {
    private Integer idProducto;
    private String nombreProducto;
    private CategoriaResponse categoria;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private Integer cantidad;
    private String descripcion;
    private String codigoBarras;
    private ProveedorResponse proveedor;
}