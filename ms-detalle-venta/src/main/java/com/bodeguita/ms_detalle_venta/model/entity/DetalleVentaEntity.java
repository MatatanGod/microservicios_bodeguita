package com.bodeguita.ms_detalle_venta.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "detalle_venta")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleVenta;

    private Long idVenta;
    private Integer idProducto;
    private String nombreProducto;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
    private LocalDateTime fechaCreacion;

    @PrePersist
    public void prePersist() {
        if (this.fechaCreacion == null) {
            this.fechaCreacion = LocalDateTime.now();
        }
    }
}