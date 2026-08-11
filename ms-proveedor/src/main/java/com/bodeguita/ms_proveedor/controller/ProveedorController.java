package com.bodeguita.ms_proveedor.controller;

import com.bodeguita.ms_proveedor.model.dto.ProveedorRequest;
import com.bodeguita.ms_proveedor.model.dto.ProveedorResponse;
import com.bodeguita.ms_proveedor.service.ProveedorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/proveedores")
public class ProveedorController {

    private ProveedorService service;

    public ProveedorController(ProveedorService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProveedorResponse> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ProveedorResponse buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ProveedorResponse registrar(@RequestBody ProveedorRequest request) {
        return service.registrar(request);
    }

    @PutMapping("/{id}")
    public ProveedorResponse actualizar(@PathVariable Long id, @RequestBody ProveedorRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}