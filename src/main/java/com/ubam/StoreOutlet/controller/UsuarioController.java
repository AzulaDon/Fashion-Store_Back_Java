package com.ubam.StoreOutlet.controller;

import com.ubam.StoreOutlet.model.Usuario;
import com.ubam.StoreOutlet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repo;

    @GetMapping
    public List<Usuario> getAll() {
        return repo.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario req) {

        Usuario user = repo.findByCorreo(req.getCorreo());

        if (user == null || !user.getClave().equals(req.getClave())) {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }

        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        usuario.setActivo(true);
        return repo.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario datos) {
        return repo.findById(id).map(u -> {
            u.setCorreo(datos.getCorreo());
            u.setTelefono(datos.getTelefono());
            u.setClave(datos.getClave());
            u.setRolId(datos.getRolId());
            return ResponseEntity.ok(repo.save(u));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        return repo.findById(id).map(u -> {
            u.setActivo(false);
            repo.save(u);
            return ResponseEntity.ok("Usuario desactivado");
        }).orElse(ResponseEntity.notFound().build());
    }
}
