package com.exacom.proyectofinal.domains;

import com.exacom.proyectofinal.validation.CoreValidation;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonaDTO {
    @NotNull(message = "{NotNull}", groups = CoreValidation.Update.class)
    @Null(message = "{Null}", groups = CoreValidation.Create.class)
    private Integer id;
    @NotBlank(message = "{NotBlank}", groups = {CoreValidation.Create.class, CoreValidation.Update.class})
    private String nombres;
    @NotBlank(message = "{NotBlank}", groups = {CoreValidation.Create.class, CoreValidation.Update.class})
    private String apellidos;
    @NotBlank(message = "{NotBlank}", groups = {CoreValidation.Create.class, CoreValidation.Update.class})
    @Email(message = "{Email}", groups = {CoreValidation.Create.class, CoreValidation.Update.class})
    private String email;
    private List<RolDTO> roles;
}
