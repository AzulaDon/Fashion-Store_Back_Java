package com.ubam.StoreOutlet.controller;

import com.ubam.StoreOutlet.model.CompraDetalle;
import com.ubam.StoreOutlet.model.views.VwDetalleCompra;
import com.ubam.StoreOutlet.repository.CompraDetalleRepository;
import com.ubam.StoreOutlet.repository.views.VwDetalleCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/compras-detalle")
@CrossOrigin(origins = "*")
public class CompraDetalleController {

    @Autowired
    private CompraDetalleRepository repo;

    @Autowired
    private VwDetalleCompraRepository vwRepo;

    @GetMapping
    public List<CompraDetalle> getAll() {
        return repo.findAll();
    }

    @GetMapping("/compra/{compraId}")
    public List<CompraDetalle> getByCompra(@PathVariable Integer compraId) {
        return repo.findByCompraId(compraId);
    }

    @GetMapping("/compra/{compraId}/detalle")
    public List<VwDetalleCompra> getDetalleView(@PathVariable Integer compraId) {
        return vwRepo.findByCompraId(compraId);
    }

    @PostMapping
    public CompraDetalle create(@RequestBody CompraDetalle detalle) {
        return repo.save(detalle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
