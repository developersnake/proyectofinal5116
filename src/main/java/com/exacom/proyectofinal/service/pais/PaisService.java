package com.exacom.proyectofinal.service.pais;

import com.exacom.proyectofinal.domains.PaisDTO;

import java.util.List;

public interface PaisService {
    List<PaisDTO> obtenerTodosLosPaises();
    PaisDTO obtenerPaisPorId(Integer id);
    PaisDTO crearPais(PaisDTO dto);
    PaisDTO modificarPais(PaisDTO dto);
}
