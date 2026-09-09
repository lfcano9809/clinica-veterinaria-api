package com.veterinaria.veterinaria.Service.ServiceImpl;

import com.veterinaria.veterinaria.Entity.Mascota;
import com.veterinaria.veterinaria.Exception.ResourceNotFoundException;
import com.veterinaria.veterinaria.Service.MascotaService;
import com.veterinaria.veterinaria.Repository.MascotaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository repository;

    public MascotaServiceImpl(MascotaRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mascota> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Mascota buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Mascota no encontrada con id: " + id
                        )
                );
    }

    @Override
    @Transactional
    public Mascota guardar(Mascota mascota) {
        return repository.save(mascota);
    }

    @Override
    @Transactional
    public Mascota actualizar(Long id, Mascota mascota) {

        Mascota existente = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Mascota no encontrada con id: " + id
                        )
                );

        existente.setNombre(mascota.getNombre());
        existente.setEspecie(mascota.getEspecie());
        existente.setRaza(mascota.getRaza());
        existente.setEdad(mascota.getEdad());
        existente.setPeso(mascota.getPeso());
        existente.setPropietario(mascota.getPropietario());

        return repository.save(existente);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

        Mascota existente = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Mascota no encontrada con id: " + id
                        )
                );

        repository.delete(existente);
    }
}
