package com.bodeguita.ms_producto.model.mapper;

import com.bodeguita.ms_producto.model.dto.*;
import com.bodeguita.ms_producto.model.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mapping(target = "idProducto", ignore = true)
    @Mapping(target = "categoria", ignore = true)   // se asigna a mano en el com.bodeguita.ms_producto.service (viene por id)
    @Mapping(target = "proveedor", ignore = true)   // idem
    Producto toEntity(ProductoRequest request);

    ProductoResponse toResponse(Producto producto);

    CategoriaResponse toCategoriaResponse(Categoria categoria);

    ProveedorResponse toProveedorResponse(Proveedor proveedor);
}