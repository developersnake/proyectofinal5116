package com.exacom.proyectofinal.mapper;

import com.exacom.proyectofinal.domains.RolDTO;
import com.exacom.proyectofinal.model.Rol;
import org.springframework.stereotype.Component;

@Component
public class RolMapper {

    public RolDTO toDTO(Rol entity) {
        return RolDTO.builder().id(entity.getId()).nombre(entity.getNombre()).build();
    }

    public Rol toEntity(RolDTO dto) {
        return Rol.builder().id(dto.getId()).nombre(dto.getNombre()).build();
    }

}
