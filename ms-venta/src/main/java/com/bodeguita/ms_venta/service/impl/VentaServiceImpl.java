package com.bodeguita.ms_venta.service.impl;

import com.bodeguita.ms_venta.model.entity.VentaEntity;
import com.bodeguita.ms_venta.repository.VentaRepository;
import com.bodeguita.ms_venta.service.VentaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;

    public VentaServiceImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<VentaEntity> listarVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Optional<VentaEntity> buscarPorId(long id) {
        return ventaRepository.findById(id);
    }

    @Override
    public VentaEntity guardarVenta(VentaEntity venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public VentaEntity actualizarVenta(long id, VentaEntity ventaDetalles) {
        VentaEntity ventaExistente = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));

        ventaExistente.setFecha(ventaDetalles.getFecha());
        ventaExistente.setCodigo_unico(ventaDetalles.getCodigo_unico());
        ventaExistente.setSub_total(ventaDetalles.getSub_total());
        ventaExistente.setIgb(ventaDetalles.getIgb());
        ventaExistente.setTotal(ventaDetalles.getTotal());
        ventaExistente.setMetodo_pago(ventaDetalles.getMetodo_pago());

        return ventaRepository.save(ventaExistente);
    }

    @Override
    public void eliminarVenta(long id) {
        VentaEntity ventaExistente = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));
        ventaRepository.delete(ventaExistente);
    }
}