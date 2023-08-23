package com.exacom.proyectofinal.service.libro;

import com.exacom.proyectofinal.domains.LibroDTO;

import java.util.List;

public interface LibroService {

    List<LibroDTO> obtenerTodosLosLibros();
    LibroDTO obtenerLibroPorId(Integer id);
    LibroDTO crearLibro(LibroDTO dto);
    LibroDTO modificarLibro(LibroDTO dto);

    List<LibroDTO> buscarPorNombre(String nombre);

    List<LibroDTO> buscarCoincidenciasPorNombre(String nombre);
    List<LibroDTO> buscarCoincidenciasPorNombreIgnorandoMayusculas(String nombre);
}
