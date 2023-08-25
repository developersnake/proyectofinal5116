package com.exacom.proyectofinal.service.servicio;

import com.exacom.proyectofinal.domains.ServicioDTO;
import com.exacom.proyectofinal.mapper.ServicioMapper;
import com.exacom.proyectofinal.model.Servicio;
import com.exacom.proyectofinal.model.pk.ServicioPK;
import com.exacom.proyectofinal.repository.ServicioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ServicioServiceImplTest {

    @InjectMocks
    private ServicioServiceImpl servicioService;

    @Mock
    private ServicioRepository servicioRepository;

    @Mock
    private ServicioMapper servicioMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerTodosLosServicios_WhenCalled_ThenReturnsAllServicesAsDTOs() {
        // Arrange
        Servicio servicio1 = new Servicio();
        Servicio servicio2 = new Servicio();
        List<Servicio> servicios = Arrays.asList(servicio1, servicio2);

        ServicioDTO servicioDTO1 = new ServicioDTO();
        ServicioDTO servicioDTO2 = new ServicioDTO();
        List<ServicioDTO> servicioDTOs = Arrays.asList(servicioDTO1, servicioDTO2);

        when(servicioRepository.findAll()).thenReturn(servicios);
        when(servicioMapper.toDto(servicio1)).thenReturn(servicioDTO1);
        when(servicioMapper.toDto(servicio2)).thenReturn(servicioDTO2);

        // Act
        List<ServicioDTO> result = servicioService.obtenerTodosLosServicios();

        // Assert
        assertEquals(servicioDTOs, result);
    }

    @Test
    public void testObtenerTodosLosServicios_WhenCalled_ThenReturnsAllServices() {
        // Arrange
        Servicio servicio1 = new Servicio();
        Servicio servicio2 = new Servicio();
        List<Servicio> servicios = Arrays.asList(servicio1, servicio2);

        when(servicioRepository.findAll()).thenReturn(servicios);

        // Act
        List<ServicioDTO> result = servicioService.obtenerTodosLosServicios();

        // Assert
        assertEquals(servicios.size(), result.size());
        verify(servicioMapper, times(servicios.size())).toDto(any(Servicio.class));
    }

    @Test
    public void testObtenerTodosLosServicios_WhenCalled_ThenCallsCorrectMethods() {
        // Arrange
        Servicio servicio1 = new Servicio();
        Servicio servicio2 = new Servicio();
        List<Servicio> servicios = Arrays.asList(servicio1, servicio2);

        when(servicioRepository.findAll()).thenReturn(servicios);

        // Act
        servicioService.obtenerTodosLosServicios();

        // Assert
        verify(servicioRepository, times(1)).findAll();
        verify(servicioMapper, times(servicios.size())).toDto(any(Servicio.class));
    }

    @Test
    public void testObtenerServicioPorId_WhenValidId_ThenReturnsServicioDTO() {
        // Arrange
        String tipoDocumento = "DNI";
        String numeroDocumento = "12345678";
        String tipoServicio = "Servicio1";

        ServicioPK servicioPK = ServicioPK.builder()
                .tipoDocumento(tipoDocumento)
                .numeroDocumento(numeroDocumento)
                .tipoServicio(tipoServicio)
                .build();

        Servicio servicio = new Servicio();
        servicio.setId(servicioPK);
        servicio.setFecha(LocalDateTime.now());
        servicio.setPrecio(100);
        servicio.setSede("Sede1");

        ServicioDTO servicioDTO = new ServicioDTO();
        servicioDTO.setTipoDocumento(tipoDocumento);
        servicioDTO.setNumeroDocumento(numeroDocumento);
        servicioDTO.setTipoServicio(tipoServicio);
        servicioDTO.setFecha(servicio.getFecha());
        servicioDTO.setPrecio(servicio.getPrecio());
        servicioDTO.setSede(servicio.getSede());

        when(servicioRepository.findById(servicioPK)).thenReturn(Optional.of(servicio));
        when(servicioMapper.toDto(servicio)).thenReturn(servicioDTO);

        // Act
        ServicioDTO result = servicioService.obtenerServicioPorId(tipoDocumento, numeroDocumento, tipoServicio);

        // Assert
        assertNotNull(result);
        assertEquals(servicioDTO, result);
        verify(servicioRepository, times(1)).findById(servicioPK);
        verify(servicioMapper, times(1)).toDto(servicio);
    }

    @Test
    public void testCrearServicio_WhenValidServicioDTO_ThenReturnsCreatedServicioDTO() {
        // Arrange
        ServicioDTO servicioDTO = new ServicioDTO();
        servicioDTO.setTipoDocumento("DNI");
        servicioDTO.setNumeroDocumento("12345678");
        servicioDTO.setTipoServicio("Servicio1");
        servicioDTO.setFecha(LocalDateTime.now());
        servicioDTO.setPrecio(100);
        servicioDTO.setSede("Sede1");

        Servicio servicio = new Servicio();
        servicio.setId(new ServicioPK());
        servicio.setFecha(servicioDTO.getFecha());
        servicio.setPrecio(servicioDTO.getPrecio());
        servicio.setSede(servicioDTO.getSede());

        when(servicioMapper.toEntity(servicioDTO)).thenReturn(servicio);
        when(servicioRepository.save(servicio)).thenReturn(servicio);
        when(servicioMapper.toDto(servicio)).thenReturn(servicioDTO);

        // Act
        ServicioDTO result = servicioService.crearServicio(servicioDTO);

        // Assert
        assertNotNull(result);
        assertEquals(servicioDTO, result);
        verify(servicioMapper, times(1)).toEntity(servicioDTO);
        verify(servicioRepository, times(1)).save(servicio);
        verify(servicioMapper, times(1)).toDto(servicio);
    }

    @Test
    public void testModificarServicio_WhenValidServicioDTO_ThenReturnsModifiedServicioDTO() {
        // Arrange
        ServicioDTO servicioDTO = new ServicioDTO();
        servicioDTO.setTipoDocumento("DNI");
        servicioDTO.setNumeroDocumento("12345678");
        servicioDTO.setTipoServicio("Servicio1");
        servicioDTO.setFecha(LocalDateTime.now());
        servicioDTO.setPrecio(100);
        servicioDTO.setSede("Sede1");

        Servicio servicio = new Servicio();
        servicio.setId(new ServicioPK());
        servicio.setFecha(servicioDTO.getFecha());
        servicio.setPrecio(servicioDTO.getPrecio());
        servicio.setSede(servicioDTO.getSede());

        when(servicioMapper.toEntity(servicioDTO)).thenReturn(servicio);
        when(servicioRepository.save(servicio)).thenReturn(servicio);
        when(servicioMapper.toDto(servicio)).thenReturn(servicioDTO);

        // Act
        ServicioDTO result = servicioService.modificarServicio(servicioDTO);

        // Assert
        assertNotNull(result);
        assertEquals(servicioDTO, result);
        verify(servicioMapper, times(1)).toEntity(servicioDTO);
        verify(servicioRepository, times(1)).save(servicio);
        verify(servicioMapper, times(1)).toDto(servicio);
    }

    @Test
    public void testEliminarServicioPorId_WhenValidId_ThenReturnsTrue() {
        // Arrange
        String tipoDocumento = "DNI";
        String numeroDocumento = "12345678";
        String tipoServicio = "Servicio1";

        ServicioPK servicioPK = ServicioPK.builder()
                .tipoDocumento(tipoDocumento)
                .numeroDocumento(numeroDocumento)
                .tipoServicio(tipoServicio)
                .build();

        // Act
        boolean result = servicioService.eliminarServicioPorId(tipoDocumento, numeroDocumento, tipoServicio);

        // Assert
        assertTrue(result);
        verify(servicioRepository, times(1)).deleteById(servicioPK);
    }
}