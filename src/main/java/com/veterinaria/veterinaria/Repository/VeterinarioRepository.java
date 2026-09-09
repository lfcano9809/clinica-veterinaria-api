package com.veterinaria.veterinaria.Repository;

import com.veterinaria.veterinaria.Entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario,Long>{
}
