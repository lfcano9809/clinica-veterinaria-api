package com.veterinaria.veterinaria.Controller;

import com.veterinaria.veterinaria.Entity.HistoriaClinica;
import com.veterinaria.veterinaria.Service.HistoriaClinicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historias-clinicas")
public class HistoriaClinicaController {

    private final HistoriaClinicaService service;

    public HistoriaClinicaController(HistoriaClinicaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<HistoriaClinica>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinica> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<HistoriaClinica> guardar(
            @RequestBody HistoriaClinica historiaClinica) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.guardar(historiaClinica));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriaClinica> actualizar(
            @PathVariable Long id,
            @RequestBody HistoriaClinica historiaClinica) {
        return ResponseEntity.ok(
                service.actualizar(id, historiaClinica)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
