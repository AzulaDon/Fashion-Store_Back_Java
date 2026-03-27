package com.ubam.StoreOutlet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubam.StoreOutlet.model.PrendaDetalle;

@Repository
public interface PrendaDetalleRepository extends JpaRepository<PrendaDetalle, Integer> {
    List<PrendaDetalle> findByPrendaId(Integer prendaId);

    PrendaDetalle findByPrendaIdAndTallaIdAndColorId(Integer prendaId, Integer tallaId, Integer colorId);

    boolean existsByPrendaIdAndTallaIdAndColorId(Integer prendaId, Integer tallaId, Integer colorId);
}
