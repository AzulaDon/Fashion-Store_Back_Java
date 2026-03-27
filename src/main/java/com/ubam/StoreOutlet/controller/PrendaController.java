package com.ubam.StoreOutlet.controller;

import com.ubam.StoreOutlet.model.Prenda;
import com.ubam.StoreOutlet.model.views.VwPrendaCompleta;
import com.ubam.StoreOutlet.repository.PrendaRepository;
import com.ubam.StoreOutlet.repository.views.VwPrendaCompletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prendas")
@CrossOrigin(origins = "*")
public class PrendaController {

    @Autowired
    private PrendaRepository prendaRepository;

    @Autowired
    private VwPrendaCompletaRepository vwRepo;

    @GetMapping
    public List<VwPrendaCompleta> getAll() {
        return vwRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prenda> getById(@PathVariable Integer id) {
        return prendaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Prenda prenda) {
        prendaRepository.insertPrenda(
                prenda.getNombre(),
                prenda.getGeneroId(),
                prenda.getTemporadaId(),
                prenda.getColeccionId()
        );
        return ResponseEntity.ok("Prenda insertada correctamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Prenda prenda) {
        prendaRepository.updatePrenda(id, prenda.getNombre());
        return ResponseEntity.ok("Prenda actualizada correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        prendaRepository.deletePrenda(id);
        return ResponseEntity.ok("Prenda desactivada correctamente");
    }
}
