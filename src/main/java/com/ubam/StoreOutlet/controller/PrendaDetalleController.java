package com.ubam.StoreOutlet.controller;

import com.ubam.StoreOutlet.DTO.PrendaConDetalleDTO;
import com.ubam.StoreOutlet.model.Prenda;
import com.ubam.StoreOutlet.model.PrendaDetalle;
import com.ubam.StoreOutlet.repository.PrendaDetalleRepository;
import com.ubam.StoreOutlet.repository.PrendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@RestController
@RequestMapping("/api/prendas-detalle")
public class PrendaDetalleController {

    @Autowired
    private PrendaRepository prendaRepository;


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

    @PostMapping("/con-detalle")
    @Transactional
    public ResponseEntity<String> insertPrendaConDetalle(@RequestBody PrendaConDetalleDTO dto) {
    
        Prenda prenda = new Prenda();
        prenda.setNombre(dto.getNombre());
        prenda.setGeneroId(dto.getGeneroId());
        prenda.setTemporadaId(dto.getTemporadaId());
        prenda.setColeccionId(dto.getColeccionId());

        Prenda guardada = prendaRepository.save(prenda);

        Integer prendaId = guardada.getPrendaId();

        PrendaDetalle detalle = new PrendaDetalle();
        detalle.setPrendaId(prendaId);          
        detalle.setColorId(dto.getColorId());
        detalle.setTallaId(dto.getTallaId());
        detalle.setPrecio(dto.getPrecio());
        detalle.setStock(dto.getStock());
        detalle.setSku(dto.getSku() != null ? dto.getSku() : "SKU-" + prendaId); // ejemplo

        repo.save(detalle);   

        return ResponseEntity.ok("Prenda y detalle insertados correctamente. ID: " + prendaId);
    }
}
