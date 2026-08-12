package com.bodeguita.ms_producto.controller;

import com.bodeguita.ms_producto.model.dto.ProductoRequest;
import com.bodeguita.ms_producto.model.dto.ProductoResponse;
import com.bodeguita.ms_producto.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    public ProductoResponse crear(@RequestBody ProductoRequest request) {
        return productoService.crear(request);
    }

    @GetMapping("/{id}")
    public ProductoResponse obtenerPorId(@PathVariable Integer id) {
        return productoService.obtenerPorId(id);
    }

    @GetMapping
    public List<ProductoResponse> listar() {
        return productoService.listarTodos();
    }

    @PutMapping("/{id}")
    public ProductoResponse actualizar(@PathVariable Integer id, @RequestBody ProductoRequest request) {
        return productoService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
    }
}