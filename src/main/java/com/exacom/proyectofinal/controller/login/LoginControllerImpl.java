package com.exacom.proyectofinal.controller.login;

import com.exacom.proyectofinal.domains.JwtToken;
import com.exacom.proyectofinal.domains.LoginDto;
import com.exacom.proyectofinal.service.login.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginControllerImpl implements LoginController {

    private final LoginService loginService;

    @Override
    public JwtToken login(LoginDto dto) {
        return loginService.login(dto);
    }

    @Override
    public LoginDto singUp(LoginDto dto) {
        return loginService.singUp(dto);
    }
}
