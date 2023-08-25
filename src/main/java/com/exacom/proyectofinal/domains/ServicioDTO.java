package com.exacom.proyectofinal.domains;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioDTO {

    @NotBlank(message = "{NotBlank}")
    @Size(min = 2, max = 2, message = "Deben ser 2 caracteres")
    private String tipoDocumento;
    @NotBlank(message = "{NotBlank}")
    private String numeroDocumento;
    @NotBlank(message = "{NotBlank}")
    private String tipoServicio;
    @NotNull(message = "{NotNull}")
    private LocalDateTime fecha;
    @NotBlank(message = "{NotBlank}")
    private String sede;
    @NotNull(message = "{NotNull}")
    private Integer precio;

}
