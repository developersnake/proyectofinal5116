package com.exacom.proyectofinal.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class CoreException extends Exception {
    private String userMessage;
    private String devMessage;

    public CoreException(String userMessage, String devMessage) {
        super(devMessage);
        this.userMessage = userMessage;
        this.devMessage = devMessage;
    }
}
