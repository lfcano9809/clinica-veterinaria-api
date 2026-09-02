package com.veterinaria.veterinaria.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "mascotas")
public class Mascota {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String nombre;
private String especie;
private String raza;
private String edad;
private double peso;

@ManyToOne
@JoinColumn(name = "propietario_id")

private Propietario propietario;

@OneToOne(mappedBy = "mascota")
private HistoriaClinica historiaClinica;

@ManyToMany
@JoinTable(
        name = "mascota_veterinario",
        joinColumns = @JoinColumn(name = "mascota_id"),
        inverseJoinColumns = @JoinColumn(name = "veterinario_id")
)
    private List<Veterinario> veterinarios;

    public Mascota() {
    }

    public Mascota(Long id, String nombre, String especie, String raza, String edad, double peso, Propietario propietario, HistoriaClinica historiaClinica, List<Veterinario> veterinarios) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.propietario = propietario;
        this.historiaClinica = historiaClinica;
        this.veterinarios = veterinarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public void setVeterinarios(List<Veterinario> veterinarios) {
        this.veterinarios = veterinarios;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                ", edad='" + edad + '\'' +
                ", peso=" + peso +
                ", propietario=" + propietario +
                ", historiaClinica=" + historiaClinica +
                ", veterinarios=" + veterinarios +
                '}';
    }
}
