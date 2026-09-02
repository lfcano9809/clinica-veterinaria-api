package com.veterinaria.veterinaria.Entity;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "veterinarios")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tarjetaProfesional;
    private String especialidad;
    private String correo;

    @ManyToMany(mappedBy = "veterinarios")
    private List<Mascota> mascotas;

    public Veterinario() {
    }

    public Veterinario(Long id, String nombre, String tarjetaProfesional, String especialidad, String correo, List<Mascota> mascotas) {
        this.id = id;
        this.nombre = nombre;
        this.tarjetaProfesional = tarjetaProfesional;
        this.especialidad = especialidad;
        this.correo = correo;
        this.mascotas = mascotas;
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

    public String getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public void setTarjetaProfesional(String tarjetaProfesional) {
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public String toString() {
        return "Veterinario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tarjetaProfesional='" + tarjetaProfesional + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", correo='" + correo + '\'' +
                ", mascotas=" + mascotas +
                '}';
    }
}
