package com.bodeguita.ms_venta.controller;

import com.bodeguita.ms_venta.model.entity.VentaEntity;
import com.bodeguita.ms_venta.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/ventas")
public class VentaController {

    private final VentaService service;

    public VentaController(VentaService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<VentaEntity>> listarVentas() {
        List<VentaEntity> ventas = service.listarVentas();
        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaEntity> buscarPorId(@PathVariable long id) {
        Optional<VentaEntity> venta = service.buscarPorId(id);
        return venta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VentaEntity> guardarVenta(@RequestBody VentaEntity venta) {
        VentaEntity nuevaVenta = service.guardarVenta(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaEntity> actualizarVenta(@PathVariable long id, @RequestBody VentaEntity ventaDetalles) {
        try {
            VentaEntity ventaActualizada = service.actualizarVenta(id, ventaDetalles);
            return ResponseEntity.ok(ventaActualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable long id) {
        try {
            service.eliminarVenta(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}