package com.bodeguita.producto.service;

import com.bodeguita.producto.model.dto.ProductoRequest;
import com.bodeguita.producto.model.dto.ProductoResponse;
import java.util.List;

public interface ProductoService {
    ProductoResponse crear(ProductoRequest request);
    ProductoResponse obtenerPorId(Integer id);
    List<ProductoResponse> listarTodos();
    ProductoResponse actualizar(Integer id, ProductoRequest request);
    void eliminar(Integer id);
}