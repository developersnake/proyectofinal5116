package com.exacom.proyectofinal.domains;

import com.exacom.proyectofinal.validation.CoreValidation;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LibroDTO {
    @NotNull(message = "{NotNull}", groups = CoreValidation.Update.class)
    @Null(message = "{Null}", groups = CoreValidation.Create.class)
    private Integer id;
    @NotBlank(message = "{NotBlank}", groups = {CoreValidation.Create.class, CoreValidation.Update.class})
    private String nombre;
    @NotBlank(message = "{NotBlank}", groups = {CoreValidation.Create.class, CoreValidation.Update.class})
    private String editorial;
    private AutorDTO autor;
    @NotNull(message = "{NotNull}", groups = {CoreValidation.Create.class, CoreValidation.Update.class})
    private Boolean isActivo;
}
