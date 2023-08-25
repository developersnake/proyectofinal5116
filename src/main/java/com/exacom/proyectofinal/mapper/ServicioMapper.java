package com.exacom.proyectofinal.mapper;

import com.exacom.proyectofinal.domains.ServicioDTO;
import com.exacom.proyectofinal.model.Servicio;
import com.exacom.proyectofinal.model.pk.ServicioPK;
import org.springframework.stereotype.Component;

@Component
public class ServicioMapper {
    public ServicioDTO toDto(Servicio entity) {
        if (entity.getId() == null) {
            return null;
        }
        return ServicioDTO.builder().tipoDocumento(entity.getId().getTipoDocumento())
                .numeroDocumento(entity.getId().getNumeroDocumento())
                .tipoServicio(entity.getId().getTipoServicio()).fecha(entity.getFecha())
                .sede(entity.getSede()).precio(entity.getPrecio()).build();
    }

    public Servicio toEntity(ServicioDTO dto) {
        var id = ServicioPK.builder().tipoServicio(dto.getTipoServicio()).tipoDocumento(dto.getTipoDocumento())
                .numeroDocumento(dto.getNumeroDocumento()).build();
        return Servicio.builder().id(id).fecha(dto.getFecha()).precio(dto.getPrecio()).sede(dto.getSede()).build();
    }
}
