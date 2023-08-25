package com.exacom.proyectofinal.service.libro;

import com.exacom.proyectofinal.domains.LibroDTO;
import com.exacom.proyectofinal.mapper.LibroMapper;
import com.exacom.proyectofinal.model.Libro;
import com.exacom.proyectofinal.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;

    @Override
    public List<LibroDTO> obtenerTodosLosLibros() {
        var lista = libroRepository.findAll();
        return lista.stream().map(libroMapper::toDto).toList();
    }

    @Override
    public LibroDTO obtenerLibroPorId(Integer id) {
        var libro = libroRepository.findById(id).orElse(Libro.builder().build());
        return libroMapper.toDto(libro);
    }

    @Override
    public LibroDTO crearLibro(LibroDTO dto) {
        var libro = libroMapper.toEntity(dto);
        return libroMapper.toDto(libroRepository.save(libro));
    }

    @Override
    public LibroDTO modificarLibro(LibroDTO dto) {
        return crearLibro(dto);
    }

    @Override
    public List<LibroDTO> buscarPorNombre(String nombre) {
        var lista = libroRepository.findByNombre(nombre);
        return lista.stream().map(libroMapper::toDto).toList();
    }

    @Override
    public List<LibroDTO> buscarCoincidenciasPorNombre(String nombre) {
        var lista = libroRepository.findByNombreContaining(nombre);
        return lista.stream().map(libroMapper::toDto).toList();
    }

    @Override
    public List<LibroDTO> buscarCoincidenciasPorNombreIgnorandoMayusculas(String nombre) {
        var lista = libroRepository.findByNombreContainingIgnoreCase(nombre);
        return lista.stream().map(libroMapper::toDto).toList();
    }

    @Override
    public List<LibroDTO> buscarCoincidenciasPorNombreNativa(String nombre) {
        var lista = libroRepository.findByNombreLikeNativa(nombre);
        return lista.stream().map(libroMapper::toDto).toList();
    }
}
