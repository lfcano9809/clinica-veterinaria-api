package com.veterinaria.veterinaria.Controller;

import com.veterinaria.veterinaria.Entity.Veterinario;
import com.veterinaria.veterinaria.Service.VeterinarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioController {

    private final VeterinarioService service;

    public VeterinarioController(VeterinarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Veterinario>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Veterinario> guardar(
            @RequestBody Veterinario veterinario) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.guardar(veterinario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinario> actualizar(
            @PathVariable Long id,
            @RequestBody Veterinario veterinario) {
        return ResponseEntity.ok(
                service.actualizar(id, veterinario)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}