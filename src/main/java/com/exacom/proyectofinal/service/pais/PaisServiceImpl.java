package com.exacom.proyectofinal.service.pais;

import com.exacom.proyectofinal.domains.PaisDTO;
import com.exacom.proyectofinal.mapper.PaisMapper;
import com.exacom.proyectofinal.model.Pais;
import com.exacom.proyectofinal.repository.PaisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PaisServiceImpl implements PaisService{

    private final PaisRepository paisRepository;
    private final PaisMapper paisMapper;
    @Override
    public List<PaisDTO> obtenerTodosLosPaises() {
        var paises = paisRepository.findAll();
        return paises.stream().map(paisMapper::toDto).toList();
    }

    @Override
    public PaisDTO obtenerPaisPorId(Integer id) {
        var pais = paisRepository.findById(id).orElse(Pais.builder().build());
        return paisMapper.toDto(pais);
    }

    @Override
    public PaisDTO crearPais(PaisDTO dto) {
        var pais = paisMapper.toEntity(dto);
        return paisMapper.toDto(paisRepository.save(pais));
    }

    @Override
    public PaisDTO modificarPais(PaisDTO dto) {
        return crearPais(dto);
    }
}
