package com.exacom.proyectofinal.repository;

import com.exacom.proyectofinal.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
