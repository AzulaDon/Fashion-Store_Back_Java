package com.ubam.StoreOutlet.controller;

import com.ubam.StoreOutlet.model.Talla;
import com.ubam.StoreOutlet.repository.TallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/tallas")
@CrossOrigin(origins = "*")
public class TallaController {

    @Autowired
    private TallaRepository repo;

    @GetMapping
    public List<Talla> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Talla> getById(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Talla create(@RequestBody Talla talla) {
        return repo.save(talla);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Talla> update(@PathVariable Integer id, @RequestBody Talla datos) {
        return repo.findById(id).map(t -> {
            t.setTalla(datos.getTalla());
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
