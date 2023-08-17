package com.exacom.proyectofinal.controller.persona;

import com.exacom.proyectofinal.domains.PersonaDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface PersonaController {

    @GetMapping("/obtenerTodasLasPersonas")
    List<PersonaDTO> obtenerTodasLasPersonas();

    @GetMapping("/obtenerPersonaPorId")
    PersonaDTO obtenerPersonaPorId(@RequestParam("id") Integer id);

    @DeleteMapping("/eliminarPersonaPorId/{id}")
    String eliminarPersonaPorId(@PathVariable("id") Integer id);

    @PostMapping("/crearPersona")
    PersonaDTO crearPersona(@RequestBody PersonaDTO dto);

    @PutMapping("/actualizarPersona")
    PersonaDTO actualizarPersona(@RequestBody PersonaDTO dto);
}
