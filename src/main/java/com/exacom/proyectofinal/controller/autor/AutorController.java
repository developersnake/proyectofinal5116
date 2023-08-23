package com.exacom.proyectofinal.controller.autor;

import com.exacom.proyectofinal.domains.AutorDTO;
import com.exacom.proyectofinal.validation.CoreValidation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1/autor")
public interface AutorController {
    @GetMapping("/obtenerTodosLosAutores")
    List<AutorDTO> obtenerTodosLosAutores();

    @GetMapping("/obtenerPorId/{id}")
    AutorDTO obtenerPorId(@PathVariable("id") Integer id);

    @PostMapping("/crearAutor")
    AutorDTO crearAutor(@Validated(CoreValidation.Create.class) @RequestBody AutorDTO dto);

    @PutMapping("/modificarAutor")
    AutorDTO modificarAutor(@Validated(CoreValidation.Update.class) @RequestBody AutorDTO dto);
}
