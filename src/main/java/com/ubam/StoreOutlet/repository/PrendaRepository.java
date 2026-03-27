package com.ubam.StoreOutlet.repository;

import com.ubam.StoreOutlet.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Integer> {

    @Procedure(procedureName = "sp_insert_prenda")
    void insertPrenda(String nombre, Integer genero, Integer temporada, Integer coleccion);

    @Procedure(procedureName = "sp_update_prenda3")
    void updatePrenda(Integer id, String nombre);

    @Procedure(procedureName = "sp_delete_prenda")
    void deletePrenda(Integer id);
}
