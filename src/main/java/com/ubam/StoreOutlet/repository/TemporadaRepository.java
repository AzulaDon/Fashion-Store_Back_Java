package com.ubam.StoreOutlet.repository;

import com.ubam.StoreOutlet.model.Temporada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemporadaRepository extends JpaRepository<Temporada, Integer> {
}
