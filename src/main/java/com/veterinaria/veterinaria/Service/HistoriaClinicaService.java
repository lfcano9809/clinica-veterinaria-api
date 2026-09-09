package com.veterinaria.veterinaria.Service;
import com.veterinaria.veterinaria.Entity.HistoriaClinica;
import java.util.List;

public interface HistoriaClinicaService {
    List<HistoriaClinica> listarTodos();
    HistoriaClinica buscarPorId(Long id);
    HistoriaClinica guardar(HistoriaClinica historiaClinica);
    HistoriaClinica actualizar(Long id, HistoriaClinica historiaClinica);
    void eliminar(Long id);

}
