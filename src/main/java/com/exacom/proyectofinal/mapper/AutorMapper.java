package com.exacom.proyectofinal.mapper;

import com.exacom.proyectofinal.domains.AutorDTO;
import com.exacom.proyectofinal.domains.LibroDTO;
import com.exacom.proyectofinal.model.Autor;
import com.exacom.proyectofinal.model.Libro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AutorMapper {

    private final PaisMapper paisMapper;
    private final LibroMapper libroMapper;

    public AutorDTO toDto(Autor entity) {
        List<LibroDTO> libros = null;
        if (entity.getLibros() != null) {
            libros = entity.getLibros().stream().map(libroMapper::toDto).toList();
        }
        var pais = paisMapper.toDto(entity.getPais());
        return AutorDTO.builder().id(entity.getId()).nombres(entity.getNombres()).edad(entity.getEdad())
                .pais(pais).libros(libros).isActivo(entity.getIsActivo()).build();
    }

    public Autor toEntity(AutorDTO dto) {
        List<Libro> libros = new ArrayList<>();
        if (dto.getLibros() != null) {
            libros = dto.getLibros().stream().map(libroMapper::toEntity).toList();
        }
        var pais = paisMapper.toEntity(dto.getPais());
        return Autor.builder().id(dto.getId()).nombres(dto.getNombres()).edad(dto.getEdad())
                .pais(pais).libros(libros).isActivo(dto.getIsActivo()).build();
    }
}
