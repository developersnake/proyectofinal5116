package com.exacom.proyectofinal.service.login;

import com.exacom.proyectofinal.domains.JwtToken;
import com.exacom.proyectofinal.domains.LoginDto;
import com.exacom.proyectofinal.mapper.LoginMapper;
import com.exacom.proyectofinal.model.Login;
import com.exacom.proyectofinal.repository.LoginRepository;
import com.exacom.proyectofinal.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final LoginMapper loginMapper;
    private final LoginRepository loginRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtToken login(LoginDto dto) {
        var login = loginRepository.findByUserName(dto.getUserName())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado."));
        dto.setRole(login.getRole());
        dto.setId(login.getId());
        var token = JwtToken.builder().build();
        var userAuth = new UsernamePasswordAuthenticationToken(dto.getUserName(), dto.getUserPassword());
        var auth = authenticationManager.authenticate(userAuth);
        if (auth.isAuthenticated()) {
            token.setAccessToken(jwtService.generateToken(dto));
        }
        return token;
    }

    @Override
    public LoginDto singUp(LoginDto dto) {
        var login = loginMapper.toEntity(dto);
        return loginMapper.toDto(loginRepository.save(login));
    }
}
