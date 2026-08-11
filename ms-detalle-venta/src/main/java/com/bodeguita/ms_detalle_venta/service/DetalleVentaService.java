package com.bodeguita.ms_detalle_venta.service;

import com.bodeguita.ms_detalle_venta.model.dto.DetalleVentaRequest;
import com.bodeguita.ms_detalle_venta.model.dto.DetalleVentaResponse;

import java.util.List;

public interface DetalleVentaService {

    List<DetalleVentaResponse> listarTodos();

    List<DetalleVentaResponse> listarPorVenta(Long idVenta);

    DetalleVentaResponse buscarPorId(Long id);

    DetalleVentaResponse registrar(DetalleVentaRequest request);

    void eliminar(Long id);
}