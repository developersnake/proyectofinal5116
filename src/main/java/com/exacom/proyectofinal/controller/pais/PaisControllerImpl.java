package com.exacom.proyectofinal.controller.pais;

import com.exacom.proyectofinal.domains.PaisDTO;
import com.exacom.proyectofinal.service.pais.PaisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaisControllerImpl implements PaisController {

    private final PaisService paisService;

    @Override
    public List<PaisDTO> obtenerTodosLosPaises() {
        return paisService.obtenerTodosLosPaises();
    }

    @Override
    public PaisDTO obtenerPaisPorId(Integer id) {
        return paisService.obtenerPaisPorId(id);
    }

    @Override
    public PaisDTO crearPais(PaisDTO dto) {
        return paisService.crearPais(dto);
    }

    @Override
    public PaisDTO modificarPais(PaisDTO dto) {
        return paisService.modificarPais(dto);
    }
}
