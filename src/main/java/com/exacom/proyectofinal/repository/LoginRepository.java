package com.exacom.proyectofinal.repository;

import com.exacom.proyectofinal.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    Optional<Login> findByUserName(String userName);
}
