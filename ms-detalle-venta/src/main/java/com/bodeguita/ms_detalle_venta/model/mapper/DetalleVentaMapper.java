package com.bodeguita.ms_detalle_venta.model.mapper;

import com.bodeguita.ms_detalle_venta.model.dto.DetalleVentaResponse;
import com.bodeguita.ms_detalle_venta.model.entity.DetalleVentaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DetalleVentaMapper {

    DetalleVentaMapper MAPPER = Mappers.getMapper(DetalleVentaMapper.class);

    DetalleVentaResponse toResponse(DetalleVentaEntity entity);
}