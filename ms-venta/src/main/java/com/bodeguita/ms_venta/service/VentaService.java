package com.bodeguita.ms_venta.service;

import com.bodeguita.ms_venta.model.dto.VentaRequest;
import com.bodeguita.ms_venta.model.dto.VentaResponse;
import com.bodeguita.ms_venta.model.entity.VentaEntity;

import java.util.List;
import java.util.Optional;

public interface VentaService {
    List<VentaEntity> listarVentas();
    Optional<VentaEntity> buscarPorId(long id);
    VentaEntity guardarVenta(VentaEntity venta);
    VentaEntity actualizarVenta(long id, VentaEntity ventaDetalles);
    void eliminarVenta(long id);
}