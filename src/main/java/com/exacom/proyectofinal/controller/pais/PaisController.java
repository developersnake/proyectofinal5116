package com.exacom.proyectofinal.controller.pais;

import com.exacom.proyectofinal.domains.PaisDTO;
import com.exacom.proyectofinal.validation.CoreValidation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1/pais")
public interface PaisController {
    @GetMapping("/obtenerTodosLosPaises")
    List<PaisDTO> obtenerTodosLosPaises();

    @GetMapping("/obtenerPaisPorId/{id}")
    PaisDTO obtenerPaisPorId(@PathVariable("id") Integer id);

    @PostMapping("/crearPais")
    PaisDTO crearPais(@Validated({CoreValidation.Create.class}) @RequestBody PaisDTO dto);

    @PutMapping("/modificarPais")
    PaisDTO modificarPais(@Validated({CoreValidation.Update.class}) @RequestBody PaisDTO dto);
}
