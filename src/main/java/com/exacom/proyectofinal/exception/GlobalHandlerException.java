package com.exacom.proyectofinal.exception;

import com.exacom.proyectofinal.domains.ResponseExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CoreException.class)
    public ResponseEntity<ResponseExceptionDTO> handleCoreException(CoreException ex, WebRequest request) {
        var response = ResponseExceptionDTO.builder().devMessage(ex.getDevMessage())
                .userMessage(ex.getUserMessage()).build();
        return ResponseEntity.status(500).body(response);
    }
}
