package com.ubam.StoreOutlet.repository.views;

import com.ubam.StoreOutlet.model.views.VwPrendaCompleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VwPrendaCompletaRepository extends JpaRepository<VwPrendaCompleta, Integer> {
}
