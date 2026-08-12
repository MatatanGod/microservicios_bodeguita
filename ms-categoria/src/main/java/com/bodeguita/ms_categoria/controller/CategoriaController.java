package com.bodeguita.ms_categoria.controller;

import com.bodeguita.ms_categoria.model.dto.CategoriaRequest;
import com.bodeguita.ms_categoria.model.dto.CategoriaResponse;
import com.bodeguita.ms_categoria.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<CategoriaResponse> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public CategoriaResponse buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public CategoriaResponse registrar(@RequestBody CategoriaRequest request) {
        return service.registrar(request);
    }

    @PutMapping("/{id}")
    public CategoriaResponse actualizar(@PathVariable Long id, @RequestBody CategoriaRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}