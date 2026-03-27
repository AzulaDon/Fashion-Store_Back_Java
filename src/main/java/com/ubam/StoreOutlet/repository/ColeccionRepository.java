package com.ubam.StoreOutlet.repository;

import com.ubam.StoreOutlet.model.Coleccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColeccionRepository extends JpaRepository<Coleccion, Integer> {
}
