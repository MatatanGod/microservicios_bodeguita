package com.bodeguita.ms_proveedor.service.impl;

import com.bodeguita.ms_proveedor.model.dto.ProveedorRequest;
import com.bodeguita.ms_proveedor.model.dto.ProveedorResponse;
import com.bodeguita.ms_proveedor.model.mapper.ProveedorMapper;
import com.bodeguita.ms_proveedor.repository.ProveedorRepository;
import com.bodeguita.ms_proveedor.service.ProveedorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private ProveedorRepository repository;

    public ProveedorServiceImpl(ProveedorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProveedorResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ProveedorMapper.MAPPER::toResponse)
                .toList();
    }

    @Override
    public ProveedorResponse buscarPorId(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return ProveedorMapper.MAPPER.toResponse(entity.get());
        } else {
            return new ProveedorResponse();
        }
    }

    @Override
    public ProveedorResponse registrar(ProveedorRequest request) {
        var entity = ProveedorMapper.MAPPER.toEntity(request);
        var guardado = repository.save(entity);
        return ProveedorMapper.MAPPER.toResponse(guardado);
    }

    @Override
    public ProveedorResponse actualizar(Long id, ProveedorRequest request) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            ProveedorMapper.MAPPER.updateEntityFromRequest(request, entity.get());
            var actualizado = repository.save(entity.get());
            return ProveedorMapper.MAPPER.toResponse(actualizado);
        } else {
            return new ProveedorResponse();
        }
    }

    @Override
    public void eliminar(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}