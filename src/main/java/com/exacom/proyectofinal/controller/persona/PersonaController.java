package com.exacom.proyectofinal.controller.persona;

import com.exacom.proyectofinal.domains.PersonaDTO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


public interface PersonaController {

    @GetMapping("/obtenerTodasLasPersonas")
    List<PersonaDTO> obtenerTodasLasPersonas();
}
