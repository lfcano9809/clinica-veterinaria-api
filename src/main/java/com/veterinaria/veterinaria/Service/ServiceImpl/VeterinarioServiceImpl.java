package com.veterinaria.veterinaria.Service.ServiceImpl;

import com.veterinaria.veterinaria.Entity.Veterinario;
import com.veterinaria.veterinaria.Exception.ResourceNotFoundException;
import com.veterinaria.veterinaria.Service.VeterinarioService;
import com.veterinaria.veterinaria.Repository.VeterinarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository repository;

    public VeterinarioServiceImpl(VeterinarioRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Veterinario> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Veterinario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Veterinario no encontrado con id: " + id
                        )
                );
    }

    @Override
    @Transactional
    public Veterinario guardar(Veterinario veterinario) {
        return repository.save(veterinario);
    }

    @Override
    @Transactional
    public Veterinario actualizar(Long id, Veterinario veterinario) {

        Veterinario existente = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Veterinario no encontrado con id: " + id
                        )
                );

        existente.setNombre(veterinario.getNombre());
        existente.setTarjetaProfesional(veterinario.getTarjetaProfesional());
        existente.setEspecialidad(veterinario.getEspecialidad());
        existente.setCorreo(veterinario.getCorreo());

        return repository.save(existente);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

        Veterinario existente = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Veterinario no encontrado con id: " + id
                        )
                );

        repository.delete(existente);
    }
}