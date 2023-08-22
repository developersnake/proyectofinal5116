package com.exacom.proyectofinal.service.autor;

import com.exacom.proyectofinal.domains.AutorDTO;

import java.util.List;

public interface AutorService {
    List<AutorDTO> obtenerTodosLosAutores();
    AutorDTO obtenerAutorPorId(Integer id);
    AutorDTO crearAutor(AutorDTO dto);
    AutorDTO madificarAutor(AutorDTO dto);
}
