package com.bodeguita.ms_venta.repository;

import com.bodeguita.ms_venta.model.entity.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Long> {
}