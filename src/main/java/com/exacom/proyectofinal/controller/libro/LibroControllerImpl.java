package com.exacom.proyectofinal.controller.libro;

import com.exacom.proyectofinal.domains.LibroDTO;
import com.exacom.proyectofinal.service.libro.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LibroControllerImpl implements LibroController {

    private final LibroService libroService;

    @Override
    public List<LibroDTO> obtenerTodosTodosLosLibros() {
        return libroService.obtenerTodosLosLibros();
    }

    @Override
    public LibroDTO obtenerLibroPorId(Integer id) {
        return libroService.obtenerLibroPorId(id);
    }

    @Override
    public LibroDTO crearLibro(LibroDTO dto) {
        return libroService.crearLibro(dto);
    }

    @Override
    public LibroDTO modificarLibro(LibroDTO dto) {
        return libroService.modificarLibro(dto);
    }

    @Override
    public List<LibroDTO> buscarPorNombre(String nombre) {
        return libroService.buscarPorNombre(nombre);
    }

    @Override
    public List<LibroDTO> buscarCoincidenciaPorNombre(String nombre) {
        return libroService.buscarCoincidenciasPorNombre(nombre);
    }

    @Override
    public List<LibroDTO> buscarCoincidenciasPorNombreIgnorandoMayusculas(String nombre) {
        return libroService.buscarCoincidenciasPorNombreIgnorandoMayusculas(nombre);
    }

    @Override
    public List<LibroDTO> buscarCoincidenciasNativa(String nombre) {
        return libroService.buscarCoincidenciasPorNombreNativa(nombre);
    }
}
