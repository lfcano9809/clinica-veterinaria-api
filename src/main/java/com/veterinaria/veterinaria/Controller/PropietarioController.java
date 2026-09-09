package com.veterinaria.veterinaria.Controller;
import com.veterinaria.veterinaria.Entity.Propietario;
import com.veterinaria.veterinaria.Service.PropietarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
@RequiredArgsConstructor
public class PropietarioController {

    private final PropietarioService service;

    @GetMapping
    public ResponseEntity<List<Propietario>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propietario> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Propietario> guardar(
            @RequestBody Propietario propietario) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.guardar(propietario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Propietario> actualizar(
            @PathVariable Long id,
            @RequestBody Propietario propietario) {

        return ResponseEntity.ok(
                service.actualizar(id, propietario)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}