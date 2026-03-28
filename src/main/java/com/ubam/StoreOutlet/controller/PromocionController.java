package com.ubam.StoreOutlet.controller;

import com.ubam.StoreOutlet.model.Promocion;
import com.ubam.StoreOutlet.repository.PromocionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promociones")
public class PromocionController {

    private final PromocionRepository promocionRepository;

    public PromocionController(PromocionRepository promocionRepository) {
        this.promocionRepository = promocionRepository;
    }

    // GET all
    @GetMapping
    public ResponseEntity<List<Promocion>> getAll() {
        return ResponseEntity.ok(promocionRepository.findAll());
    }

    // GET solo activas
    @GetMapping("/activas")
    public ResponseEntity<List<Promocion>> getActivas() {
        return ResponseEntity.ok(
            promocionRepository.findAll().stream()
                .filter(p -> Boolean.TRUE.equals(p.getActivo()))
                .toList()
        );
    }

    // GET por id
    @GetMapping("/{id}")
    public ResponseEntity<Promocion> getById(@PathVariable Integer id) {
        return promocionRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // POST crear
    @PostMapping
    public ResponseEntity<Promocion> crear(@RequestBody Promocion promocion) {
        if (promocion.getFechaInicio() != null && promocion.getFechaFin() != null
                && promocion.getFechaInicio().isAfter(promocion.getFechaFin())) {
            return ResponseEntity.badRequest().build();
        }
        Promocion saved = promocionRepository.save(promocion);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // PUT actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Promocion> actualizar(
            @PathVariable Integer id,
            @RequestBody Promocion datos) {

        return promocionRepository.findById(id).map(existing -> {
            if (datos.getDescuentoPorcentaje() != null)
                existing.setDescuentoPorcentaje(datos.getDescuentoPorcentaje());
            if (datos.getFechaInicio() != null)
                existing.setFechaInicio(datos.getFechaInicio());
            if (datos.getFechaFin() != null)
                existing.setFechaFin(datos.getFechaFin());
            if (datos.getActivo() != null)
                existing.setActivo(datos.getActivo());
            return ResponseEntity.ok(promocionRepository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!promocionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        promocionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}