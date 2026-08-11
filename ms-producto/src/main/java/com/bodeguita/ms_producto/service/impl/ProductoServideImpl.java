package com.bodeguita.producto.service.impl;

import com.bodeguita.producto.model.dto.ProductoRequest;
import com.bodeguita.producto.model.dto.ProductoResponse;
import com.bodeguita.producto.model.entity.Categoria;
import com.bodeguita.producto.model.entity.Producto;
import com.bodeguita.producto.model.entity.Proveedor;
import com.bodeguita.producto.model.mapper.ProductoMapper;
import com.bodeguita.producto.repository.CategoriaRepository;
import com.bodeguita.producto.repository.ProductoRepository;
import com.bodeguita.producto.repository.ProveedorRepository;
import com.bodeguita.producto.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProveedorRepository proveedorRepository;
    private final ProductoMapper productoMapper;

    @Override
    public ProductoResponse crear(ProductoRequest request) {
        Producto producto = productoMapper.toEntity(request);
        producto.setCategoria(obtenerCategoria(request.getIdCategoria()));
        if (request.getIdProveedor() != null) {
            producto.setProveedor(obtenerProveedor(request.getIdProveedor()));
        }
        return productoMapper.toResponse(productoRepository.save(producto));
    }

    @Override
    public ProductoResponse obtenerPorId(Integer id) {
        return productoMapper.toResponse(buscarProducto(id));
    }

    @Override
    public List<ProductoResponse> listarTodos() {
        return productoRepository.findAll().stream()
                .map(productoMapper::toResponse)
                .toList();
    }

    @Override
    public ProductoResponse actualizar(Integer id, ProductoRequest request) {
        Producto producto = buscarProducto(id);
        producto.setNombreProducto(request.getNombreProducto());
        producto.setPrecioCompra(request.getPrecioCompra());
        producto.setPrecioVenta(request.getPrecioVenta());
        producto.setCantidad(request.getCantidad());
        producto.setDescripcion(request.getDescripcion());
        producto.setCodigoBarras(request.getCodigoBarras());
        producto.setCategoria(obtenerCategoria(request.getIdCategoria()));
        producto.setProveedor(request.getIdProveedor() != null ? obtenerProveedor(request.getIdProveedor()) : null);
        return productoMapper.toResponse(productoRepository.save(producto));
    }

    @Override
    public void eliminar(Integer id) {
        productoRepository.delete(buscarProducto(id));
    }

    private Producto buscarProducto(Integer id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + id));
    }

    private Categoria obtenerCategoria(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada: " + id));
    }

    private Proveedor obtenerProveedor(Integer id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado: " + id));
    }
}