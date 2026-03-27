package com.ubam.StoreOutlet.controller;

import com.ubam.StoreOutlet.model.Color;
import com.ubam.StoreOutlet.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/colores")
@CrossOrigin(origins = "*")
public class ColorController {

    @Autowired
    private ColorRepository repo;

    @GetMapping
    public List<Color> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> getById(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Color create(@RequestBody Color color) {
        return repo.save(color);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Color> update(@PathVariable Integer id, @RequestBody Color datos) {
        return repo.findById(id).map(c -> {
            c.setColor(datos.getColor());
            c.setCodigoHexa(datos.getCodigoHexa());
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
