package com.bodeguita.ms_categoria.repository;

import com.bodeguita.ms_categoria.model.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

    Optional<CategoriaEntity> findByNombreCategoria(String nombreCategoria);

    boolean existsByNombreCategoria(String nombreCategoria);
}