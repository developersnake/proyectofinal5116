package com.exacom.proyectofinal.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolDTO {
    private Integer id;
    private String nombre;
}
