package com.veterinaria.veterinaria.Service;
import com.veterinaria.veterinaria.Entity.Mascota;
import java.util.List;

public interface MascotaService {
    List<Mascota> listarTodos();
    Mascota buscarPorId(Long id);
    Mascota guardar(Mascota mascota);
    Mascota actualizar(Long id, Mascota mascota);
    void eliminar(Long id);
}
