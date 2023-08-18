package com.exacom.proyectofinal.mapper;

import com.exacom.proyectofinal.domains.PersonaDTO;
import com.exacom.proyectofinal.domains.RolDTO;
import com.exacom.proyectofinal.model.Persona;
import com.exacom.proyectofinal.model.Rol;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RolMapper {

    public RolDTO toDTO(Rol entity) {
        List<PersonaDTO> personasDTO = new ArrayList<>();
        if (entity.getPersonas() != null) {
            personasDTO = entity.getPersonas().stream().map(this::toPersonaDTO).toList();
        }
        return RolDTO.builder().id(entity.getId()).nombre(entity.getNombre()).personas(personasDTO).build();
    }

    public Rol toEntity(RolDTO dto) {
        List<Persona> personas = null;
        if (dto.getPersonas() != null) {
            personas = dto.getPersonas().stream().map(this::toPersona).toList();
        }
        return Rol.builder().id(dto.getId()).nombre(dto.getNombre()).personas(personas).build();
    }

    private PersonaDTO toPersonaDTO(Persona entity) {
        return PersonaDTO.builder().id(entity.getId()).nombres(entity.getNombres())
                .apellidos(entity.getApellidos()).email(entity.getEmail()).build();
    }

    private Persona toPersona(PersonaDTO dto) {
        return Persona.builder().id(dto.getId()).nombres(dto.getNombres())
                .apellidos(dto.getApellidos()).email(dto.getEmail()).build();
    }

}
