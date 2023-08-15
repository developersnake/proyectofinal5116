package com.exacom.proyectofinal.controller.persona;

import com.exacom.proyectofinal.domains.PersonaDTO;
import com.exacom.proyectofinal.service.persona.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonaControllerImpl implements PersonaController {

    private final PersonaService personaService;

    @Override
    public List<PersonaDTO> obtenerTodasLasPersonas() {
        return personaService.obtenerTodasLasPersonas();
    }
}
