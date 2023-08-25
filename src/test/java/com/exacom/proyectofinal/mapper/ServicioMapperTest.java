package com.exacom.proyectofinal.mapper;

import com.exacom.proyectofinal.domains.ServicioDTO;
import com.exacom.proyectofinal.model.Servicio;
import com.exacom.proyectofinal.model.pk.ServicioPK;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioMapperTest {

    private final ServicioMapper servicioMapper = new ServicioMapper();

    @Test
    public void testToDto_WhenEntityIsNotNull_ThenReturnsServicioDTO() {
        // Arrange
        ServicioPK id = ServicioPK.builder()
                .tipoDocumento("DNI")
                .numeroDocumento("12345678")
                .tipoServicio("Servicio1")
                .build();

        Servicio entity = Servicio.builder()
                .id(id)
                .fecha(LocalDateTime.now())
                .precio(100)
                .sede("Sede1")
                .build();

        // Act
        ServicioDTO result = servicioMapper.toDto(entity);

        // Assert
        assertEquals(id.getTipoDocumento(), result.getTipoDocumento());
        assertEquals(id.getNumeroDocumento(), result.getNumeroDocumento());
        assertEquals(id.getTipoServicio(), result.getTipoServicio());
        assertEquals(entity.getFecha(), result.getFecha());
        assertEquals(entity.getPrecio(), result.getPrecio());
        assertEquals(entity.getSede(), result.getSede());
    }

    @Test
    public void testToEntity_WhenDtoIsNotNull_ThenReturnsServicio() {
        // Arrange
        ServicioDTO dto = new ServicioDTO();
        dto.setTipoDocumento("DNI");
        dto.setNumeroDocumento("12345678");
        dto.setTipoServicio("Servicio1");
        dto.setFecha(LocalDateTime.now());
        dto.setPrecio(100);
        dto.setSede("Sede1");

        // Act
        Servicio result = servicioMapper.toEntity(dto);

        // Assert
        assertEquals(dto.getTipoDocumento(), result.getId().getTipoDocumento());
        assertEquals(dto.getNumeroDocumento(), result.getId().getNumeroDocumento());
        assertEquals(dto.getTipoServicio(), result.getId().getTipoServicio());
        assertEquals(dto.getFecha(), result.getFecha());
        assertEquals(dto.getPrecio(), result.getPrecio());
        assertEquals(dto.getSede(), result.getSede());
    }
}