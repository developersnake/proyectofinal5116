package com.exacom.proyectofinal.repository;

import com.exacom.proyectofinal.model.Servicio;
import com.exacom.proyectofinal.model.pk.ServicioPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepository extends JpaRepository<Servicio, ServicioPK> {
}
