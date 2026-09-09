package com.veterinaria.veterinaria.Repository;
import com.veterinaria.veterinaria.Entity.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica,Long> {

}
