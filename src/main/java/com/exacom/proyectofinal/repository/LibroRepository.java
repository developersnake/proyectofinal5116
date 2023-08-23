package com.exacom.proyectofinal.repository;

import com.exacom.proyectofinal.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

    List<Libro> findByNombre(String nombre);

    List<Libro> findByNombreContaining(String nombre);

    @Query("FROM Libro l WHERE l.nombre LIKE '%:nombre%'")
    List<Libro> findByNombreContainingIgnoreCase(String nombre);

}
