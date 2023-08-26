package com.exacom.proyectofinal.service.login;

import com.exacom.proyectofinal.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var login = loginRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login no encontrado"));
        return new User(login.getUserName(), login.getUserPassword(), new ArrayList<>());
    }
}
