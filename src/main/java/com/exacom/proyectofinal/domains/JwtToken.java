package com.exacom.proyectofinal.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtToken {
    private String accessToken;
    }
