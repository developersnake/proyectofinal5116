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

    @Override
    public PersonaDTO obtenerPersonaPorId(Integer id) {
        return personaService.obtenerPersonaPorId(id);
    }

    @Override
    public String eliminarPersonaPorId(Integer id) {
        String mensaje;
        var isDelete = personaService.eliminarPersonaPorId(id);
        if (isDelete) {
            mensaje = "Se ha eliminado el registro " + id + " correctamente.";
        } else {
            mensaje = "Ocurrió un error al eliminar el registro con id. " + id;
        }
        return mensaje;
    }

    @Override
    public PersonaDTO crearPersona(PersonaDTO dto) {
        return personaService.crearPersona(dto);
    }

    @Override
    public PersonaDTO actualizarPersona(PersonaDTO dto) {
        return personaService.actualizarPersona(dto);
    }
}
