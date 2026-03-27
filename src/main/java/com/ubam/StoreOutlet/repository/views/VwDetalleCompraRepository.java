package com.ubam.StoreOutlet.repository.views;

import com.ubam.StoreOutlet.model.views.VwDetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VwDetalleCompraRepository extends JpaRepository<VwDetalleCompra, Integer> {

    List<VwDetalleCompra> findByCompraId(Integer compraId);
}
