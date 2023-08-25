package com.exacom.proyectofinal.controller.libro;

import com.exacom.proyectofinal.domains.LibroDTO;
import com.exacom.proyectofinal.validation.CoreValidation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/v1/libro")
public interface LibroController {
    @GetMapping("/obtenerTodosLosLibros")
    List<LibroDTO> obtenerTodosTodosLosLibros();
    @GetMapping("/obtenerLibroPorId/{id}")
    LibroDTO obtenerLibroPorId(@PathVariable("id") Integer id);
    @PostMapping("/crearLibro")
    LibroDTO crearLibro(@Validated(CoreValidation.Create.class) @RequestBody LibroDTO dto);
    @PutMapping("/modificarLibro")
    LibroDTO modificarLibro(@Validated(CoreValidation.Update.class) @RequestBody LibroDTO dto);

    @GetMapping("/buscarPorNombre")
    List<LibroDTO> buscarPorNombre(@RequestParam("libro") String nombre);

    @GetMapping("/buscarCoincidenciaPorNombre")
    List<LibroDTO> buscarCoincidenciaPorNombre(@RequestParam("nombre") String nombre);

    @GetMapping("/buscarCoincidenciasPorNombreIgnorandoMayusculas")
    List<LibroDTO> buscarCoincidenciasPorNombreIgnorandoMayusculas(@RequestParam("nombre") String nombre);

    @GetMapping("/buscarCoincidenciasNativa")
    List<LibroDTO> buscarCoincidenciasNativa(@RequestParam("nombre") String nombre);
}
