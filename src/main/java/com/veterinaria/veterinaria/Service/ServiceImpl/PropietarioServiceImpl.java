package com.veterinaria.veterinaria.Service.ServiceImpl;

import com.veterinaria.veterinaria.Entity.Propietario;
import com.veterinaria.veterinaria.Exception.ResourceNotFoundException;
import com.veterinaria.veterinaria.Repository.PropietarioRepository;
import com.veterinaria.veterinaria.Service.PropietarioService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PropietarioServiceImpl implements PropietarioService {

    private final PropietarioRepository repository;

    public PropietarioServiceImpl(PropietarioRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Propietario> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Propietario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Propietario no encontrado con id: " + id
                        )
                );
    }

    @Override
    @Transactional
    public Propietario guardar(Propietario propietario) {
        return repository.save(propietario);
    }

    @Override
    @Transactional
    public Propietario actualizar(Long id, Propietario propietario) {

        Propietario existente = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Propietario no encontrado con id: " + id
                        )
                );

        existente.setNombre(propietario.getNombre());
        existente.setDocumento(propietario.getDocumento());
        existente.setTelefono(propietario.getTelefono());
        existente.setCorreo(propietario.getCorreo());

        return repository.save(existente);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

        Propietario existente = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Propietario no encontrado con id: " + id
                        )
                );

        repository.delete(existente);
    }
}
