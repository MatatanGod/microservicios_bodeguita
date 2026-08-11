package com.bodeguita.ms_categoria.service;

import com.bodeguita.ms_categoria.model.dto.CategoriaRequest;
import com.bodeguita.ms_categoria.model.dto.CategoriaResponse;

import java.util.List;

public interface CategoriaService {

    List<CategoriaResponse> listarTodos();

    CategoriaResponse buscarPorId(Long id);

    CategoriaResponse registrar(CategoriaRequest request);

    CategoriaResponse actualizar(Long id, CategoriaRequest request);

    void eliminar(Long id);
}