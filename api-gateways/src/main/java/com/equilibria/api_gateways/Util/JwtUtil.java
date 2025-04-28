package com.equilibria.api_gateways.Util;

import java.security.Key;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {

   // private String secretKey;
   public static final String secretKey = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    public void validateToken(final String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
        } catch (JwtException e) {
            throw new RuntimeException("Invalid JWT token: " + e.getMessage());
        }
    }

    private Key getSignKey() {
        if (secretKey == null || secretKey.isEmpty()) {
            throw new RuntimeException("Secret key is not initialized properly.");
        }
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
