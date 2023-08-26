package com.exacom.proyectofinal.service.jwt;

import com.exacom.proyectofinal.domains.LoginDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateToken(LoginDto dto);

    boolean validatedToken(String token, UserDetails userDetails);

    public String extractData(String token);
}
