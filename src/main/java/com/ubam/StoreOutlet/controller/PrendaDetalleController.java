package com.ubam.StoreOutlet.controller;

import com.ubam.StoreOutlet.model.PrendaDetalle;
import com.ubam.StoreOutlet.repository.PrendaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prendas-detalle")
public class PrendaDetalleController {

    @Autowired
    private PrendaDetalleRepository repo;

    @GetMapping
    public List<PrendaDetalle> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrendaDetalle> getById(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/prenda/{prendaId}")
    public List<PrendaDetalle> getByPrenda(@PathVariable Integer prendaId) {
        return repo.findByPrendaId(prendaId);
    }

    @PostMapping
    public PrendaDetalle create(@RequestBody PrendaDetalle detalle) {
        return repo.save(detalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrendaDetalle> update(@PathVariable Integer id, @RequestBody PrendaDetalle datos) {
        return repo.findById(id).map(d -> {
            d.setStock(datos.getStock());
            d.setPrecio(datos.getPrecio());
            d.setColorId(datos.getColorId());
            d.setTallaId(datos.getTallaId());
            d.setSku(datos.getSku());
            return ResponseEntity.ok(repo.save(d));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
