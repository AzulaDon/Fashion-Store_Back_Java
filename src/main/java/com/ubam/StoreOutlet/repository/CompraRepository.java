package com.ubam.StoreOutlet.repository;

import com.ubam.StoreOutlet.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

    List<Compra> findByUsuarioId(Integer usuarioId);

    @Procedure(procedureName = "sp_insert_compra")
    void insertCompra(Integer usuarioId, Float total);
}
