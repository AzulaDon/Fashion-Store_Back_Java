package com.ubam.StoreOutlet.controller;

import com.ubam.StoreOutlet.model.Coleccion;
import com.ubam.StoreOutlet.repository.ColeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/colecciones")
@CrossOrigin(origins = "*")
public class ColeccionController {

    @Autowired
    private ColeccionRepository repo;

    @GetMapping
    public List<Coleccion> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coleccion> getById(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Coleccion create(@RequestBody Coleccion coleccion) {
        return repo.save(coleccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coleccion> update(@PathVariable Integer id, @RequestBody Coleccion datos) {
        return repo.findById(id).map(c -> {
            c.setColeccion(datos.getColeccion());
            return ResponseEntity.ok(repo.save(c));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
