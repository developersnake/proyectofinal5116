package com.exacom.proyectofinal.mapper;

import com.exacom.proyectofinal.domains.PaisDTO;
import com.exacom.proyectofinal.model.Pais;
import org.springframework.stereotype.Component;

@Component
public class PaisMapper {

    public PaisDTO toDto(Pais entity) {
        return PaisDTO.builder().id(entity.getId()).nombre(entity.getNombre()).isActivo(entity.getIsActivo()).build();
    }

    public Pais toEntity(PaisDTO dto) {
        return Pais.builder().id(dto.getId()).nombre(dto.getNombre()).isActivo(dto.getIsActivo()).build();
    }


}
