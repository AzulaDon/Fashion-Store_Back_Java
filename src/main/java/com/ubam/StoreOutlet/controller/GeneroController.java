package com.ubam.StoreOutlet.controller;

import com.ubam.StoreOutlet.model.Genero;
import com.ubam.StoreOutlet.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/generos")
@CrossOrigin(origins = "*")
public class GeneroController {

    @Autowired
    private GeneroRepository repo;

    @GetMapping
    public List<Genero> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> getById(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Genero create(@RequestBody Genero genero) {
        return repo.save(genero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genero> update(@PathVariable Integer id, @RequestBody Genero datos) {
        return repo.findById(id).map(g -> {
            g.setGenero(datos.getGenero());
            return ResponseEntity.ok(repo.save(g));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
