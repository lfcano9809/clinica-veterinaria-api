package com.veterinaria.veterinaria.Controller;

import com.veterinaria.veterinaria.Entity.Mascota;
import com.veterinaria.veterinaria.Service.MascotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final MascotaService service;

    public MascotaController(MascotaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Mascota>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Mascota> guardar(@RequestBody Mascota mascota) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.guardar(mascota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizar(
            @PathVariable Long id,
            @RequestBody Mascota mascota) {
        return ResponseEntity.ok(service.actualizar(id, mascota));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}