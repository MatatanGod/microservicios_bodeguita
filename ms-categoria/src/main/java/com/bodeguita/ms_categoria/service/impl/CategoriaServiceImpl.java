package com.bodeguita.ms_categoria.service.impl;

import com.bodeguita.ms_categoria.model.dto.CategoriaRequest;
import com.bodeguita.ms_categoria.model.dto.CategoriaResponse;
import com.bodeguita.ms_categoria.model.mapper.CategoriaMapper;
import com.bodeguita.ms_categoria.repository.CategoriaRepository;
import com.bodeguita.ms_categoria.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoriaResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(CategoriaMapper.MAPPER::toResponse)
                .toList();
    }

    @Override
    public CategoriaResponse buscarPorId(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return CategoriaMapper.MAPPER.toResponse(entity.get());
        } else {
            return new CategoriaResponse();
        }
    }

    @Override
    public CategoriaResponse registrar(CategoriaRequest request) {
        var entity = CategoriaMapper.MAPPER.toEntity(request);
        var guardado = repository.save(entity);
        return CategoriaMapper.MAPPER.toResponse(guardado);
    }

    @Override
    public CategoriaResponse actualizar(Long id, CategoriaRequest request) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            CategoriaMapper.MAPPER.updateEntityFromRequest(request, entity.get());
            var actualizado = repository.save(entity.get());
            return CategoriaMapper.MAPPER.toResponse(actualizado);
        } else {
            return new CategoriaResponse();
        }
    }

    @Override
    public void eliminar(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}