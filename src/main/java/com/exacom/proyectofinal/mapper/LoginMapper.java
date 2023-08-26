package com.exacom.proyectofinal.mapper;

import com.exacom.proyectofinal.domains.LoginDto;
import com.exacom.proyectofinal.model.Login;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {
    public LoginDto toDto(Login entity) {
        return LoginDto.builder().id(entity.getId()).userPassword(entity.getUserPassword())
                .userName(entity.getUserName()).role(entity.getRole()).build();
    }
    public Login toEntity(LoginDto dto) {
        return Login.builder().id(dto.getId()).userPassword(dto.getUserPassword())
                .userName(dto.getUserName()).role(dto.getRole()).build();
    }

}
