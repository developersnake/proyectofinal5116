package com.exacom.proyectofinal.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private Integer id;
    private String nombres;
    private String apellidos;
    private String email;
}
