package com.exacom.proyectofinal.controller.autor;

import com.exacom.proyectofinal.domains.AutorDTO;
import com.exacom.proyectofinal.service.autor.AutorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AutorControllerImpl implements AutorController {

    private final AutorService autorService;

    @Override
    public List<AutorDTO> obtenerTodosLosAutores() {
        return autorService.obtenerTodosLosAutores();
    }

    @Override
    public AutorDTO obtenerPorId(Integer id) {
        return autorService.obtenerAutorPorId(id);
    }

    @Override
    public AutorDTO crearAutor(AutorDTO dto) {
        log.info(dto.toString());
        return autorService.crearAutor(dto);
    }

    @Override
    public AutorDTO modificarAutor(AutorDTO dto) {
        return autorService.madificarAutor(dto);
    }
}
