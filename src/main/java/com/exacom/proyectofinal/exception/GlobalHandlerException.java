package com.exacom.proyectofinal.exception;

import com.exacom.proyectofinal.domains.ResponseExceptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalHandlerException {

    @ExceptionHandler(CoreException.class)
    public ResponseEntity<ResponseExceptionDTO> handleCoreException(CoreException ex) {
        log.error("Error CoreException: {}", ex.getMessage(), ex);
        var response = ResponseExceptionDTO.builder().devMessage(ex.getDevMessage())
                .userMessage(ex.getUserMessage()).build();
        return ResponseEntity.status(500).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        log.error("Error MethodArgumentNotValidException: {}", ex.getMessage(), ex);
        var list = new ArrayList<String>();
        ex.getBindingResult().getFieldErrors().forEach(x ->
                list.add("Propiedad " + x.getField() + ", " + x.getDefaultMessage())
        );
        return ResponseEntity.status(400).body(list);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseExceptionDTO> handleExceptionGeneric(Exception ex) {
        log.error("Error {}: {}", ex.getClass(), ex.getMessage(), ex);
        var response = ResponseExceptionDTO.builder().devMessage(ex.getMessage())
                .userMessage("Ocurrió un error, por favor intenta mas tarde.").build();
        return ResponseEntity.status(500).body(response);
    }
}
