package com.exacom.proyectofinal.controller.rol;

import com.exacom.proyectofinal.domains.RolDTO;
import com.exacom.proyectofinal.exception.CoreException;
import com.exacom.proyectofinal.service.rol.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RolControllerImpl implements RolController {

    private final RolService rolService;

    @Override
    public List<RolDTO> obtenerTodosLosRoles() {
        return rolService.obtenerTodosLosRoles();
    }

    @Override
    public RolDTO obtenerRolPorId(Integer id) {
        return rolService.obtenerRolPorId(id);
    }

    @Override
    public RolDTO crearRol(RolDTO dto) throws CoreException {
        return rolService.crearRol(dto);
    }

    @Override
    public RolDTO actualizarRol(RolDTO dto) throws CoreException {
        return rolService.actualizarRol(dto);
    }
}
