package com.exacom.proyectofinal.service.servicio;

import com.exacom.proyectofinal.domains.ServicioDTO;

import java.util.List;

public interface ServicioService {
    List<ServicioDTO> obtenerTodosLosServicios();
    ServicioDTO obtenerServicioPorId(String tipoDocumento, String numeroDocumento, String tipoServicio);

    ServicioDTO crearServicio(ServicioDTO dto);
    ServicioDTO modificarServicio(ServicioDTO dto);

    boolean eliminarServicioPorId(String tipoDocumento, String numeroDocumento, String tipoServicio);
}
