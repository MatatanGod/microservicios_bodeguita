package com.bodeguita.ms_detalle_venta.client;

import com.bodeguita.ms_detalle_venta.model.dto.ProductoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-producto")
public interface ProductoClient {

    @GetMapping("/api/productos/{id}")
    ProductoResponse obtenerProducto(@PathVariable("id") Integer id);
}