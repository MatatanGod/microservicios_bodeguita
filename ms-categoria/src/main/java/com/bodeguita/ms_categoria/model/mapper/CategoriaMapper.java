package com.bodeguita.ms_categoria.model.mapper;

import com.bodeguita.ms_categoria.model.dto.CategoriaRequest;
import com.bodeguita.ms_categoria.model.dto.CategoriaResponse;
import com.bodeguita.ms_categoria.model.entity.CategoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaMapper {

    CategoriaMapper MAPPER = Mappers.getMapper(CategoriaMapper.class);

    CategoriaEntity toEntity(CategoriaRequest request);

    CategoriaResponse toResponse(CategoriaEntity entity);

    void updateEntityFromRequest(CategoriaRequest request, @MappingTarget CategoriaEntity entity);
}