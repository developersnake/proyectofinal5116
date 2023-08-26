package com.exacom.proyectofinal.controller.login;

import com.exacom.proyectofinal.domains.JwtToken;
import com.exacom.proyectofinal.domains.LoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/login")
public interface LoginController {
    @PostMapping("/login")
    public JwtToken login(@RequestBody LoginDto dto);
    @PostMapping("/singUp")
    public LoginDto singUp(@RequestBody LoginDto dto);
}
