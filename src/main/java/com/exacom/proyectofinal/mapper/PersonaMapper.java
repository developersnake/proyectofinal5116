package com.exacom.proyectofinal.mapper;

import com.exacom.proyectofinal.domains.PersonaDTO;
import com.exacom.proyectofinal.model.Persona;
import org.springframework.stereotype.Component;

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
        return PersonaDTO.builder().id(entity.getId()).nombres(entity.getNombres())
                .apellidos(entity.getApellidos()).email(entity.getEmail()).build();
    }

    /**
     * Método para convertir una personaDTO de persona a una entidad de persona
     *
     * @param dto Datos del registro de persona.
     * @return Un objeto de Persona con los datos del registro.
     */
    public Persona toEntity(PersonaDTO dto) {
        return Persona.builder().id(dto.getId()).nombres(dto.getNombres())
                .apellidos(dto.getApellidos()).email(dto.getEmail()).build();
    }
}
