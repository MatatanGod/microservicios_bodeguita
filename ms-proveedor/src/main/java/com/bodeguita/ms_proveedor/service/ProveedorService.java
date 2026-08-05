package com.bodeguita.ms_proveedor.service;

import com.bodeguita.ms_proveedor.model.dto.ProveedorRequest;
import com.bodeguita.ms_proveedor.model.dto.ProveedorResponse;

import java.util.List;

public interface ProveedorService {

    List<ProveedorResponse> listarTodos();

    ProveedorResponse buscarPorId(Long id);

    ProveedorResponse registrar(ProveedorRequest request);

    ProveedorResponse actualizar(Long id, ProveedorRequest request);

    void eliminar(Long id);
}
