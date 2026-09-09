package com.veterinaria.veterinaria.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "historias_clinicas")
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaApertura;
    private String antecedentes;
    private String observaciones;

    @OneToOne
    @JoinColumn(name = "mascota_id", unique = true)
    private Mascota mascota;

    public HistoriaClinica() {
    }

    public HistoriaClinica(Long id, LocalDate fechaApertura,
                           String antecedentes, String observaciones,
                           Mascota mascota) {
        this.id = id;
        this.fechaApertura = fechaApertura;
        this.antecedentes = antecedentes;
        this.observaciones = observaciones;
        this.mascota = mascota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public String toString() {
        return "HistoriaClinica{" +
                "id=" + id +
                ", fechaApertura=" + fechaApertura +
                ", antecedentes='" + antecedentes + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", mascota=" + mascota +
                '}';
    }
}