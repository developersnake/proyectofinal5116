package com.exacom.proyectofinal.service.persona;

import com.exacom.proyectofinal.domains.PersonaDTO;
import com.exacom.proyectofinal.mapper.PersonaMapper;
import com.exacom.proyectofinal.model.Persona;
import com.exacom.proyectofinal.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonaServiceImpl implements PersonaService {

    private final PersonaMapper personaMapper;
    private final PersonaRepository personaRepository;

    @Override
    public PersonaDTO obtenerPersonaPorId(Integer id) {
        log.info("Ingresando al método PersonaServiceImpl.obtenerPersonaPorId, por el id: {}", id);
        var persona = personaRepository.findById(id).orElse(Persona.builder().build());
        log.info("Finalizando el método PersonaServiceImpl.obtenerPersonaPorId");
        return personaMapper.toDTO(persona);
    }

    @Override
    public List<PersonaDTO> obtenerTodasLasPersonas() {
        log.info("Ingresando al método PersonaServiceImpl.obtenerTodasLasPersonas");
        var list = personaRepository.findAll();
        log.info("Finalizando el método PersonaServiceImpl.obtenerTodasLasPersonas");
        return list.stream().map(personaMapper::toDTO).toList();
    }

    @Override
    public PersonaDTO crearPersona(PersonaDTO dto) {
        log.info("Ingresando al método PersonaServiceImpl.crearPersona, creando la persona: {}", dto);
        var persona = personaMapper.toEntity(dto);
        log.info("Finalizando el método PersonaServiceImpl.crearPersona");
        return personaMapper.toDTO(personaRepository.save(persona));
    }

    @Override
    public PersonaDTO actualizarPersona(PersonaDTO dto) {
        return crearPersona(dto);
    }

    @Override
    public boolean eliminarPersonaPorId(Integer id) {
        log.info("Ingresando al método PersonaServiceImpl.eliminarPersonaPorId, eliminando el id: {}", id);
        personaRepository.deleteById(id);
        log.info("Finalizando el método PersonaServiceImpl.eliminarPersonaPorId");
        return true;
    }
}
