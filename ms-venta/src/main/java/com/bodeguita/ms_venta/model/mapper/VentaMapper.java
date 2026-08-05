package com.bodeguita.ms_venta.model.mapper;

import com.bodeguita.ms_venta.model.dto.VentaRequest;
import com.bodeguita.ms_venta.model.dto.VentaResponse;
import com.bodeguita.ms_venta.model.entity.VentaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VentaMapper {

    VentaMapper MAPPER= Mappers.getMapper(VentaMapper.class);
    VentaResponse toVentaResponse(VentaEntity entity);
    VentaEntity toVentaEntity(VentaRequest request);
}
