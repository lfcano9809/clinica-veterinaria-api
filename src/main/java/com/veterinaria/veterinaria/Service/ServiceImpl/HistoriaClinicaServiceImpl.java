package com.veterinaria.veterinaria.Service.ServiceImpl;

import com.veterinaria.veterinaria.Entity.HistoriaClinica;
import com.veterinaria.veterinaria.Entity.Mascota;
import com.veterinaria.veterinaria.Exception.ResourceNotFoundException;
import com.veterinaria.veterinaria.Service.HistoriaClinicaService;
import com.veterinaria.veterinaria.Repository.HistoriaClinicaRepository;
import com.veterinaria.veterinaria.Repository.MascotaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository repository;
    private final MascotaRepository mascotaRepository;

    public HistoriaClinicaServiceImpl(HistoriaClinicaRepository repository,
                                      MascotaRepository mascotaRepository) {
        this.repository = repository;
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<HistoriaClinica> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public HistoriaClinica buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Historia clinica no encontrada con id: " + id
                        )
                );
    }

    @Override
    @Transactional
    public HistoriaClinica guardar(HistoriaClinica historiaClinica) {

        if (historiaClinica.getMascota() != null &&
                historiaClinica.getMascota().getId() != null) {

            Mascota mascota = mascotaRepository.findById(
                    historiaClinica.getMascota().getId()
            ).orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Mascota no encontrada con id: " +
                                    historiaClinica.getMascota().getId()
                    )
            );

            historiaClinica.setMascota(mascota);
        }

        return repository.save(historiaClinica);
    }

    @Override
    @Transactional
    public HistoriaClinica actualizar(Long id, HistoriaClinica historiaClinica) {

        HistoriaClinica existente = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Historia clinica no encontrada con id: " + id
                        )
                );

        existente.setFechaApertura(historiaClinica.getFechaApertura());
        existente.setAntecedentes(historiaClinica.getAntecedentes());
        existente.setObservaciones(historiaClinica.getObservaciones());

        if (historiaClinica.getMascota() != null &&
                historiaClinica.getMascota().getId() != null) {

            Mascota mascota = mascotaRepository.findById(
                    historiaClinica.getMascota().getId()
            ).orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Mascota no encontrada con id: " +
                                    historiaClinica.getMascota().getId()
                    )
            );

            existente.setMascota(mascota);
        }

        return repository.save(existente);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

        HistoriaClinica existente = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Historia clinica no encontrada con id: " + id
                        )
                );

        /*
         * Antes de eliminar la historia clínica,
         * eliminamos la referencia que tiene la mascota.
         */
        if (existente.getMascota() != null) {

            Mascota mascota = existente.getMascota();

            mascota.setHistoriaClinica(null);

            mascotaRepository.save(mascota);
        }

        repository.delete(existente);
    }
}