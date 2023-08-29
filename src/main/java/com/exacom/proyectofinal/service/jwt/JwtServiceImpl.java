package com.exacom.proyectofinal.service.jwt;

import com.exacom.proyectofinal.domains.LoginDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@Slf4j
public class JwtServiceImpl implements JwtService {
    public static final String JWT_SECRET = "CursoJaEE7";

    @Override
    public String generateToken(LoginDto dto) {
        var payload = new HashMap<String, Object>();
        payload.put("role", dto.getRole());
        payload.put("uid", dto.getId());

        return this.createToken(payload, dto.getUserName());
    }

    @Override
    public boolean validatedToken(String token, UserDetails userDetails) {
        log.info("token: " + token);
        log.info("userDetailsService: " + userDetails);
        var user = this.extractData(token);
        return (user.equalsIgnoreCase(userDetails.getUsername()) && !this.isExpiredToken(token));
    }

    @Override
    public String extractData(String token) {
        return this.extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final var claims = this.extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
    }

    private String createToken(Map<String, Object> payload, String subject) {
        return Jwts.builder().setClaims(payload).setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 100 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET).compact();
    }

    private boolean isExpiredToken(String token) {
        return this.extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return this.extractClaims(token, Claims::getExpiration);
    }
}
