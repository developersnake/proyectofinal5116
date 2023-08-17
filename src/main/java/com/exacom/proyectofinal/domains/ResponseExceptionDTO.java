package com.exacom.proyectofinal.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseExceptionDTO {
    private String userMessage;
    private String devMessage;
}
