package com.bodeguita.ms_detalle_venta.service.impl;

import com.bodeguita.ms_detalle_venta.client.ProductoClient;
import com.bodeguita.ms_detalle_venta.model.dto.DetalleVentaRequest;
import com.bodeguita.ms_detalle_venta.model.dto.DetalleVentaResponse;
import com.bodeguita.ms_detalle_venta.model.dto.ProductoResponse;
import com.bodeguita.ms_detalle_venta.model.entity.DetalleVentaEntity;
import com.bodeguita.ms_detalle_venta.model.mapper.DetalleVentaMapper;
import com.bodeguita.ms_detalle_venta.repository.DetalleVentaRepository;
import com.bodeguita.ms_detalle_venta.service.DetalleVentaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

    private final DetalleVentaRepository repository;
    private final ProductoClient productoClient;

    public DetalleVentaServiceImpl(DetalleVentaRepository repository, ProductoClient productoClient) {
        this.repository = repository;
        this.productoClient = productoClient;
    }

    @Override
    public List<DetalleVentaResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(DetalleVentaMapper.MAPPER::toResponse)
                .toList();
    }

    @Override
    public List<DetalleVentaResponse> listarPorVenta(Long idVenta) {
        return repository.findByIdVenta(idVenta)
                .stream()
                .map(DetalleVentaMapper.MAPPER::toResponse)
                .toList();
    }

    @Override
    public DetalleVentaResponse buscarPorId(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return DetalleVentaMapper.MAPPER.toResponse(entity.get());
        } else {
            return new DetalleVentaResponse();
        }
    }

    @Override
    public DetalleVentaResponse registrar(DetalleVentaRequest request) {
        // Comunicación entre microservicios: se consulta ms-producto para traer el precio vigente
        ProductoResponse producto = productoClient.obtenerProducto(request.getIdProducto());

        BigDecimal precioUnitario = producto.getPrecioVenta();
        BigDecimal subtotal = precioUnitario.multiply(BigDecimal.valueOf(request.getCantidad()));

        var entity = DetalleVentaEntity.builder()
                .idVenta(request.getIdVenta())
                .idProducto(request.getIdProducto())
                .nombreProducto(producto.getNombreProducto())
                .cantidad(request.getCantidad())
                .precioUnitario(precioUnitario)
                .subtotal(subtotal)
                .build();

        var guardado = repository.save(entity);
        return DetalleVentaMapper.MAPPER.toResponse(guardado);
    }

    @Override
    public void eliminar(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}