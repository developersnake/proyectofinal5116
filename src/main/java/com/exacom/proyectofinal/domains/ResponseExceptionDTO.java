package com.exacom.proyectofinal.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseExceptionDTO {
    private String userMessage;
    private String devMessage;
}
