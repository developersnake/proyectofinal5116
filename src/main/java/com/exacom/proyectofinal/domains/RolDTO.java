package com.exacom.proyectofinal.domains;

import com.exacom.proyectofinal.validation.CoreValidation;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolDTO {
    @NotNull(message = "{NotNull}", groups = CoreValidation.Update.class)
    @Null(message = "{Null}", groups = CoreValidation.Create.class)
    private Integer id;
    @NotBlank(message ="{NotBlank}", groups = {CoreValidation.Create.class, CoreValidation.Update.class})
    private String nombre;
    private List<PersonaDTO> personas;
}
