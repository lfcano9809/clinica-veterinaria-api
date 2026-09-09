package com.veterinaria.veterinaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.veterinaria.veterinaria.Entity.Propietario;


    @Repository
    public interface PropietarioRepository extends JpaRepository<Propietario,Long>{

    }




