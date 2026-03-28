package com.ubam.StoreOutlet.controller;

import com.ubam.StoreOutlet.model.Compra;
import com.ubam.StoreOutlet.model.views.VwCompra;
import com.ubam.StoreOutlet.repository.CompraRepository;
import com.ubam.StoreOutlet.repository.views.VwCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    @Autowired
    private CompraRepository repo;

    @Autowired
    private VwCompraRepository vwRepo;

    @GetMapping
    public List<VwCompra> getAll() {
        return vwRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> getById(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Compra> getByUsuario(@PathVariable Integer usuarioId) {
        return repo.findByUsuarioId(usuarioId);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Compra compra) {
        repo.insertCompra(compra.getUsuarioId(), compra.getTotal());
        return ResponseEntity.ok("Compra registrada correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        return repo.findById(id).map(c -> {
            c.setActivo(false);
            repo.save(c);
            return ResponseEntity.ok("Compra cancelada");
        }).orElse(ResponseEntity.notFound().build());
    }
}
