package com.exacom.proyectofinal.controller.servicio;

import com.exacom.proyectofinal.domains.ServicioDTO;
import com.exacom.proyectofinal.service.servicio.ServicioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ServicioControllerImplTest {

    private static final String URL_PATH = "/api/v1/servicio";

    @Mock
    private ServicioService servicioService;

    @InjectMocks
    private ServicioControllerImpl servicioController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(servicioController).build();
    }

    @Test
    @DisplayName("Obtener todos los servicios")
    void obtenerTodosLosServicios() throws Exception {
        when(servicioService.obtenerTodosLosServicios()).thenReturn(this.getServicioDtoList());

        mockMvc.perform(get(URL_PATH + "/obtenerTodosLosServicios").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].tipoDocumento").value("CC"))
                .andExpect(jsonPath("$.[0].numeroDocumento").value("1236547895"))
                .andExpect(jsonPath("$.[0].tipoServicio").value("Psicología"))
                .andReturn().getRequest();

    }

    @Test
    @DisplayName("Obtener el servicio por id.")
    void obtenerServicioPorId() throws Exception {
        var servicioDTO = this.getServicioDTO("CC", "98756324", "Ortodoncia",
                "Fontibon", 145000);
        when(servicioService.obtenerServicioPorId(anyString(), anyString(), anyString())).thenReturn(servicioDTO);

        mockMvc.perform(get(URL_PATH + "/obtenerServicioPorId/CC/123658/ortodoncia")
                        .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tipoDocumento").value("CC"))
                .andExpect(jsonPath("$.numeroDocumento").value("98756324"))
                .andExpect(jsonPath("$.tipoServicio").value("Ortodoncia"))
                .andReturn().getRequest();

    }

    @Test
    @DisplayName("Crear un servicio")
    void crearServicio() throws Exception {

        var servicioDTO = this.getServicioDTO("CC", "98756324", "Ortodoncia",
                "Fontibon", 145000);

        String json = getJsonRequest();

        when(servicioService.crearServicio(any(ServicioDTO.class))).thenReturn(servicioDTO);

        mockMvc.perform(
                        post(URL_PATH + "/crearServicio")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json).accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tipoDocumento").value("CC"))
                .andExpect(jsonPath("$.numeroDocumento").value("98756324"))
                .andExpect(jsonPath("$.tipoServicio").value("Ortodoncia"))
                .andReturn().getRequest();

    }

        @Test
        @DisplayName("modificar servicio")
        void modificarServicio() throws Exception {

            var servicioDTO = this.getServicioDTO("CC", "98756324", "Ortodoncia",
                    "Fontibon", 145000);

            String json = getJsonRequest();

            when(servicioService.modificarServicio(any(ServicioDTO.class))).thenReturn(servicioDTO);

            mockMvc.perform(
                            put(URL_PATH + "/modificarServicio")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(json).accept(MediaType.APPLICATION_JSON)
                    )
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.tipoDocumento").value("CC"))
                    .andExpect(jsonPath("$.numeroDocumento").value("98756324"))
                    .andExpect(jsonPath("$.tipoServicio").value("Ortodoncia"))
                    .andReturn().getRequest();

            verify(servicioService, times(1)).modificarServicio(any(ServicioDTO.class));
        }

        @Test
        @DisplayName("Eliminar un servicio")
        void eliminarServicioPorId() throws Exception {

            when(servicioService.eliminarServicioPorId(anyString(), anyString(), anyString())).thenReturn(Boolean.TRUE);

            mockMvc.perform(delete(URL_PATH + "/eliminarServicioPorId/CC/123658/ortodoncia")
                            .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn().getRequest();

        }

    private ServicioDTO getServicioDTO(String tipoDocumento, String numeroDocumento, String tipoServicio,
                                       String sede, Integer precio) {
        return ServicioDTO.builder().tipoDocumento(tipoDocumento).numeroDocumento(numeroDocumento)
                .precio(precio).fecha(LocalDateTime.now()).sede(sede).tipoServicio(tipoServicio).build();
    }

    private List<ServicioDTO> getServicioDtoList() {
        var lista = new ArrayList<ServicioDTO>();
        lista.add(this.getServicioDTO("CC", "1236547895", "Psicología",
                "Teusaquillo", 96000));
        lista.add(this.getServicioDTO("TI", "9856217875", "Pediatria",
                "Chapinero", 86000));
        lista.add(this.getServicioDTO("CE", "PA36547895", "Peso saludable",
                "Kenedy", 99000));
        return lista;
    }

    private String getJsonRequest() {
        return """
                {
                  "tipoDocumento": "CC",
                  "numeroDocumento": "98756324",
                  "tipoServicio": "Ortodoncia",
                  "fecha": "2023-08-25T00:28:46.831Z",
                  "sede": "Fontibon",
                  "precio": 145000
                }""";
    }
}