package com.exacom.proyectofinal.service.servicio;

import com.exacom.proyectofinal.domains.ServicioDTO;
import com.exacom.proyectofinal.mapper.ServicioMapper;
import com.exacom.proyectofinal.model.Servicio;
import com.exacom.proyectofinal.model.pk.ServicioPK;
import com.exacom.proyectofinal.repository.ServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;
    private final ServicioMapper servicioMapper;

    @Override
    public List<ServicioDTO> obtenerTodosLosServicios() {
        var lista = servicioRepository.findAll();
        return lista.stream().map(servicioMapper::toDto).toList();
    }

    @Override
    public ServicioDTO obtenerServicioPorId(String tipoDocumento, String numeroDocumento, String tipoServicio) {
        var id = this.getServicioPK(tipoDocumento, numeroDocumento, tipoServicio);
        var servicio = servicioRepository.findById(id).orElse(Servicio.builder().build());
        return servicioMapper.toDto(servicio);
    }

    @Override
    public ServicioDTO crearServicio(ServicioDTO dto) {
        var servicio = servicioMapper.toEntity(dto);
        return servicioMapper.toDto(servicioRepository.save(servicio));
    }

    @Override
    public ServicioDTO modificarServicio(ServicioDTO dto) {
        return this.crearServicio(dto);
    }

    @Override
    public boolean eliminarServicioPorId(String tipoDocumento, String numeroDocumento, String tipoServicio) {
        var servicio = this.getServicioPK(tipoDocumento, numeroDocumento, tipoServicio);
        servicioRepository.deleteById(servicio);
        return true;
    }

    private ServicioPK getServicioPK(String tipoDocumento, String numeroDocumento, String tipoServicio) {
        return ServicioPK.builder().tipoServicio(tipoServicio).tipoDocumento(tipoDocumento)
                .numeroDocumento(numeroDocumento).build();
    }
}
