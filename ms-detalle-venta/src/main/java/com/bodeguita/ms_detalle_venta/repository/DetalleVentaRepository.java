package com.bodeguita.ms_detalle_venta.repository;

import com.bodeguita.ms_detalle_venta.model.entity.DetalleVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVentaEntity, Long> {

    List<DetalleVentaEntity> findByIdVenta(Long idVenta);
}