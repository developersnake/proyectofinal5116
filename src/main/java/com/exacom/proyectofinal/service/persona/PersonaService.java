package com.exacom.proyectofinal.service.persona;

import com.exacom.proyectofinal.domains.PersonaDTO;

import java.util.List;

public interface PersonaService {
    /**
     * Méto para consultar por id una persona.
     * @param id Identificador de la persona.
     * @return Objeto PersonaDTO con los datos de la consulta.
     */
    PersonaDTO obtenerPersonaPorId(Integer id);

    /**
     * Método para consultar los registros de las personas
     * @return Retorna todos los registros de la tabla.
     */
    List<PersonaDTO> obtenerTodasLasPersonas();

    /**
     * Método para crear una persona.
     * @param dto Objeto PersonaDTO con la información a crear.
     * @return Un objeto PersonaDTO con la información de la persona creada.
     */
    PersonaDTO crearPersona(PersonaDTO dto);

    /**
     * Método para actualizar una persona.
     * @param dto Objeto PersonaDTO con la información a modificar
     * @return Un objeto PersonaDTO con la información de la persona modificada.
     */
    PersonaDTO actualizarPersona(PersonaDTO dto);

    /**
     * Método para eliminar una persona por id.
     * @param id Identificador de la persona.
     * @return true = elina registro, false = no se elimino el registro.
     */
    boolean eliminarPersonaPorId(Integer id);
}
