package com.bodeguita.ms_detalle_venta.controller;

import com.bodeguita.ms_detalle_venta.model.dto.DetalleVentaRequest;
import com.bodeguita.ms_detalle_venta.model.dto.DetalleVentaResponse;
import com.bodeguita.ms_detalle_venta.service.DetalleVentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/detalle-ventas")
public class DetalleVentaController {

    private final DetalleVentaService service;

    public DetalleVentaController(DetalleVentaService service) {
        this.service = service;
    }

    @GetMapping
    public List<DetalleVentaResponse> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/venta/{idVenta}")
    public List<DetalleVentaResponse> listarPorVenta(@PathVariable Long idVenta) {
        return service.listarPorVenta(idVenta);
    }

    @GetMapping("/{id}")
    public DetalleVentaResponse buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public DetalleVentaResponse registrar(@RequestBody DetalleVentaRequest request) {
        return service.registrar(request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}