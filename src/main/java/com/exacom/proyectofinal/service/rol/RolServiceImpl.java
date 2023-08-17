package com.exacom.proyectofinal.service.rol;

import com.exacom.proyectofinal.domains.RolDTO;
import com.exacom.proyectofinal.exception.CoreException;
import com.exacom.proyectofinal.mapper.RolMapper;
import com.exacom.proyectofinal.model.Rol;
import com.exacom.proyectofinal.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    @Override
    public RolDTO obtenerRolPorId(Integer id) {
        var rol = rolRepository.findById(id).orElse(Rol.builder().build());
        return rolMapper.toDTO(rol);
    }

    @Override
    public List<RolDTO> obtenerTodosLosRoles() {
        var roles = rolRepository.findAll();
        return roles.stream().map(rolMapper::toDTO).toList();
    }

    @Override
    public RolDTO crearRol(RolDTO dto) throws CoreException {
        if(dto.getId() != null){
            throw new CoreException("No debe enviar el id del rol para crearlo.", "Valida el error");
        }
        var rol = rolMapper.toEntity(dto);
        rol = rolRepository.save(rol);
        return rolMapper.toDTO(rol);
    }

    @Override
    public RolDTO actualizarRol(RolDTO dto) throws CoreException {
        if(dto.getId() == null){
            throw new CoreException("Es necesario el id del rol para actualizarlo.", "Valida este error");
        }
        return crearRol(dto);
    }
}
