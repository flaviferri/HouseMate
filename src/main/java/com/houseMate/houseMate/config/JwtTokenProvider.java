package com.houseMate.houseMate.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private static final String SECRET_KEY = "yqgTEsv0derhwlSrVeKd7W5p+CgIXRFsxNMmW62Hajs=";

    // Genera un token JWT
    public String generateToken(String username, int userId) {
        return Jwts.builder()
                .setSubject(username) // Configura el subject (en este caso, el email)
                .claim("userId", userId) // Incluye el userId en los claims
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 864_000_000)) // Expiración en 10 días
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Extrae el userId del token JWT
    public int extractUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();

        Object userIdClaim = claims.get("userId");
        if (userIdClaim == null) {
            throw new RuntimeException("User ID claim is missing from token");
        }

        return Integer.parseInt(userIdClaim.toString());
    }

    // Extrae el username del token JWT
    public String extractUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();
        return claims.getSubject();
    }
}
