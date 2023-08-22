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
public class LibroMapper {

    private final PaisMapper paisMapper;

    public LibroDTO toDto(Libro entity) {
        var autor = this.toAutorDto(entity.getAutor());
        return LibroDTO.builder().id(entity.getId()).nombre(entity.getNombre()).isActivo(entity.getIsActivo())
                .editorial(entity.getEditorial()).autor(autor).build();
    }

    public Libro toEntity(LibroDTO dto) {
        var autor = this.toAutor(dto.getAutor());
        return Libro.builder().id(dto.getId()).nombre(dto.getNombre()).isActivo(dto.getIsActivo())
                .editorial(dto.getEditorial()).autor(autor).build();
    }

    private AutorDTO toAutorDto(Autor entity) {
        List<LibroDTO> libros = new ArrayList<>();
        if (entity.getLibros() != null) {
            libros = entity.getLibros().stream().map(this::toDto).toList();
        }
        var pais = paisMapper.toDto(entity.getPais());
        return AutorDTO.builder().id(entity.getId()).nombres(entity.getNombres()).edad(entity.getEdad())
                .pais(pais).libros(libros).build();
    }

    private Autor toAutor(AutorDTO dto) {
        List<Libro> libros = new ArrayList<>();
        if (dto.getLibros() != null) {
            libros = dto.getLibros().stream().map(this::toEntity).toList();
        }
        var pais = paisMapper.toEntity(dto.getPais());
        return Autor.builder().id(dto.getId()).nombres(dto.getNombres()).edad(dto.getEdad())
                .pais(pais).libros(libros).build();
    }


}
