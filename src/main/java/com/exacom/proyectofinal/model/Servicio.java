package com.exacom.proyectofinal.model;

import com.exacom.proyectofinal.model.pk.ServicioPK;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "servicios")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Servicio {
    @EmbeddedId
    private ServicioPK id;
    private LocalDateTime fecha;
    private Integer precio;
    private String sede;
}
