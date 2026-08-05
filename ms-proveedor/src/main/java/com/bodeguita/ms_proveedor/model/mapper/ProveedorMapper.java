package com.bodeguita.ms_proveedor.model.mapper;

import com.bodeguita.ms_proveedor.model.dto.ProveedorRequest;
import com.bodeguita.ms_proveedor.model.dto.ProveedorResponse;
import com.bodeguita.ms_proveedor.model.entity.ProveedorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProveedorMapper {

    ProveedorMapper MAPPER = Mappers.getMapper(ProveedorMapper.class);

    ProveedorEntity toEntity(ProveedorRequest request);

    ProveedorResponse toResponse(ProveedorEntity entity);

    void updateEntityFromRequest(ProveedorRequest request, @MappingTarget ProveedorEntity entity);
}