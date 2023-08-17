package com.exacom.proyectofinal.domains;

import com.exacom.proyectofinal.validation.RolValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolDTO {
    @NotNull(message = "git {rol.id.NotNull}", groups = RolValidation.Update.class)
    @Null(message = "{rol.id.Null}", groups = RolValidation.Create.class)
    private Integer id;
    @NotBlank(message ="{rol.nombre.NotBlank}", groups = {RolValidation.Create.class, RolValidation.Update.class})
    private String nombre;
}
