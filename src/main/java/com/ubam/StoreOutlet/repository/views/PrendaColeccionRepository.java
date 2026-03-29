package com.ubam.StoreOutlet.repository.views;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubam.StoreOutlet.model.views.PrendaColeccionView;

public interface PrendaColeccionRepository extends JpaRepository<PrendaColeccionView, Integer> {
    List<PrendaColeccionView> findByPrendaColeccionId(Integer id);
}
