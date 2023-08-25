package com.exacom.proyectofinal.controller.servicio;

import com.exacom.proyectofinal.domains.ServicioDTO;
import com.exacom.proyectofinal.service.servicio.ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ServicioControllerImpl implements ServicioController {

    private final ServicioService servicioService;
    @Override
    public List<ServicioDTO> obtenerTodosLosServicios() {
        return servicioService.obtenerTodosLosServicios();
    }

    @Override
    public ServicioDTO obtenerServicioPorId(String tipoDocumento, String numeroDocumento, String tipoServicio) {
        return servicioService.obtenerServicioPorId(tipoDocumento, numeroDocumento, tipoServicio);
    }

    @Override
    public ServicioDTO crearServicio(ServicioDTO servicio) {
        return servicioService.crearServicio(servicio);
    }

    @Override
    public ServicioDTO modificarServicio(ServicioDTO servicio) {
        return servicioService.modificarServicio(servicio);
    }

    @Override
    public String eliminarServicioPorId(String tipoDocumento, String numeroDocumento, String tipoServicio) {
        servicioService.eliminarServicioPorId(tipoDocumento, numeroDocumento, tipoServicio);
        return "Se elimino el registro correctamente.";
    }
}
