package com.ubam.StoreOutlet.repository.views;

import com.ubam.StoreOutlet.model.views.VwCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VwCompraRepository extends JpaRepository<VwCompra, Integer> {
}
