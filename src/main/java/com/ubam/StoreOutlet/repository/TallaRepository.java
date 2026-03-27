package com.ubam.StoreOutlet.repository;

import com.ubam.StoreOutlet.model.Talla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TallaRepository extends JpaRepository<Talla, Integer> {
}
