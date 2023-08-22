package com.exacom.proyectofinal.service.autor;

import com.exacom.proyectofinal.domains.AutorDTO;
import com.exacom.proyectofinal.mapper.AutorMapper;
import com.exacom.proyectofinal.model.Autor;
import com.exacom.proyectofinal.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl implements AutorService {

    private final AutorRepository autorRepository;
    private final AutorMapper autorMapper;

    @Override
    public List<AutorDTO> obtenerTodosLosAutores() {
        var lista = autorRepository.findAll();
        return lista.stream().map(autorMapper::toDto).toList();
    }

    @Override
    public AutorDTO obtenerAutorPorId(Integer id) {
        var autor = autorRepository.findById(id).orElse(Autor.builder().build());
        return autorMapper.toDto(autor);
    }

    @Override
    public AutorDTO crearAutor(AutorDTO dto) {
        var autor = autorMapper.toEntity(dto);
        return autorMapper.toDto(autorRepository.save(autor));
    }

    @Override
    public AutorDTO madificarAutor(AutorDTO dto) {
        return crearAutor(dto);
    }
}
