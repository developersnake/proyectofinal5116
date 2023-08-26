package com.exacom.proyectofinal.service.login;

import com.exacom.proyectofinal.domains.JwtToken;
import com.exacom.proyectofinal.domains.LoginDto;

public interface LoginService {
    JwtToken login(LoginDto dto);
    LoginDto singUp(LoginDto dto);
}
