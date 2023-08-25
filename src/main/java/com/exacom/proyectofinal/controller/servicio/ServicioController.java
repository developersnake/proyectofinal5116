package com.exacom.proyectofinal.controller.servicio;

import com.exacom.proyectofinal.domains.ServicioDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1/servicio")
public interface ServicioController {
    @GetMapping("/obtenerTodosLosServicios")
    List<ServicioDTO> obtenerTodosLosServicios();

    @GetMapping("/obtenerServicioPorId/{tipoDocumento}/{numeroDocumento}/{tipoServicio}")
    ServicioDTO obtenerServicioPorId(@PathVariable("tipoDocumento") String tipoDocumento,
                                     @PathVariable("numeroDocumento") String numeroDocumento,
                                     @PathVariable("tipoServicio") String tipoServicio);

    @PostMapping("/crearServicio")
    ServicioDTO crearServicio(@Valid @RequestBody ServicioDTO servicio);

    @PutMapping("/modificarServicio")
    ServicioDTO modificarServicio(@Valid @RequestBody ServicioDTO servicio);

    @DeleteMapping("/eliminarServicioPorId/{tipoDocumento}/{numeroDocumento}/{tipoServicio}")
    String eliminarServicioPorId(@PathVariable("tipoDocumento") String tipoDocumento,
                                 @PathVariable("numeroDocumento") String numeroDocumento,
                                 @PathVariable("tipoServicio") String tipoServicio);

}
