package com.exacom.proyectofinal.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDto {
    private Integer id;
    private String userName;
    private String userPassword;
    private String role;
}
