package com.ubam.StoreOutlet.controller;

import com.ubam.StoreOutlet.model.Temporada;
import com.ubam.StoreOutlet.repository.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/temporadas")
@CrossOrigin(origins = "*")
public class TemporadaController {

    @Autowired
    private TemporadaRepository repo;

    @GetMapping
    public List<Temporada> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Temporada> getById(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Temporada create(@RequestBody Temporada temporada) {
        return repo.save(temporada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Temporada> update(@PathVariable Integer id, @RequestBody Temporada datos) {
        return repo.findById(id).map(t -> {
            t.setTemporada(datos.getTemporada());
            return ResponseEntity.ok(repo.save(t));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
