package com.exacom.proyectofinal.repository;

import com.exacom.proyectofinal.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}