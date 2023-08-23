package com.exacom.proyectofinal.controller.rol;

import com.exacom.proyectofinal.domains.RolDTO;
import com.exacom.proyectofinal.exception.CoreException;
import com.exacom.proyectofinal.validation.CoreValidation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("api/v1/rol")
public interface RolController {
    @GetMapping("/obtenerTodosLosRoles")
    List<RolDTO> obtenerTodosLosRoles();

    @GetMapping("/obtenerRolPorId/{id}")
    RolDTO obtenerRolPorId(@PathVariable("id") Integer id);

    @PostMapping("/crearRol")
    RolDTO crearRol(@Validated({CoreValidation.Create.class}) @RequestBody RolDTO dto) throws CoreException;

    @PutMapping("/actualizarRol")
    RolDTO actualizarRol(@Validated(CoreValidation.Update.class) @RequestBody RolDTO dto) throws CoreException;
}
