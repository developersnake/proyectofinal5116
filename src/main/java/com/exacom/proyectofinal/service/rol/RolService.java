package com.exacom.proyectofinal.service.rol;

import com.exacom.proyectofinal.domains.RolDTO;
import com.exacom.proyectofinal.exception.CoreException;

import java.util.List;

public interface RolService {

    RolDTO obtenerRolPorId(Integer id);

    List<RolDTO> obtenerTodosLosRoles();

    RolDTO crearRol(RolDTO dto) throws CoreException;

    RolDTO actualizarRol(RolDTO dto) throws CoreException;
}
