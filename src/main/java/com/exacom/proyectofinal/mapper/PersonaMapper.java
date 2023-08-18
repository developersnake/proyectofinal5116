package com.exacom.proyectofinal.mapper;

import com.exacom.proyectofinal.domains.PersonaDTO;
import com.exacom.proyectofinal.domains.RolDTO;
import com.exacom.proyectofinal.model.Persona;
import com.exacom.proyectofinal.model.Rol;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Funciona para convertir un objeto de Persona en PersonaDTO y viceversa.
 */
@Component
public class PersonaMapper {

    /**
     * Método para convertir una entidad de persona a una personaDTO
     *
     * @param entity Representa un registro de la taba personas.
     * @return Retorna un objeto de PersonaDTO con los datos del registro.
     */
    public PersonaDTO toDTO(Persona entity) {
        List<RolDTO> rolesDTO = new ArrayList<>();
        if (entity.getRoles() != null) {
            rolesDTO = entity.getRoles().stream().map(this::toRolDTO).toList();
        }
        return PersonaDTO.builder().id(entity.getId()).nombres(entity.getNombres())
                .roles(rolesDTO).apellidos(entity.getApellidos()).email(entity.getEmail()).build();
    }

    /**
     * Método para convertir una personaDTO de persona a una entidad de persona
     *
     * @param dto Datos del registro de persona.
     * @return Un objeto de Persona con los datos del registro.
     */
    public Persona toEntity(PersonaDTO dto) {
        List<Rol> roles = null;
        if (dto.getRoles() != null) {
            roles = dto.getRoles().stream().map(this::toRol).toList();
        }
        return Persona.builder().id(dto.getId()).nombres(dto.getNombres())
                .roles(roles).apellidos(dto.getApellidos()).email(dto.getEmail()).build();
    }

    private RolDTO toRolDTO(Rol entity) {
        return RolDTO.builder().id(entity.getId()).nombre(entity.getNombre()).build();
    }

    private Rol toRol(RolDTO dto) {
        return Rol.builder().id(dto.getId()).nombre(dto.getNombre()).build();
    }
}
