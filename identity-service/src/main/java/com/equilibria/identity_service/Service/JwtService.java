package com.equilibria.identity_service.Service;

import java.security.Key;
/* import java.security.NoSuchAlgorithmException; */
import java.sql.Date;
/* import java.util.Base64; */
import java.util.HashMap;
import java.util.Map;

/* import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey; */

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

    
    
    public static final String secretKey = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";


    /*
    private static final int KEY_LENGTH = 256;
    private String secretKey;
    
    public JwtService(){
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            keyGen.init(KEY_LENGTH);
            SecretKey secret =keyGen.generateKey();
            this.secretKey = Base64.getEncoder().encodeToString(secret.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to generate secret key", e);
        }
    } 
    */

    public String getSecretKey() {
        return JwtService.secretKey;
    } 

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public void validateToken(final String token)
    {
        Jwts.parserBuilder()
            .setSigningKey(getSignKey())
            .build()
            .parseClaimsJws(token);
    }

    public String generateToken(String username){
        
        Map<String,Object> claims=new HashMap<>();
        return createToken(claims,username);
    }

  // @SuppressWarnings("deprecation")
    private String createToken(Map<String, Object> claims, String username) {
        
        /* claims.put("sub", username);
        claims.put("iat",new Date(System.currentTimeMillis()));
        claims.put("exp",new Date(System.currentTimeMillis()+1000*60*30)); */


        return Jwts.builder()
                   .setClaims(claims)
                   .setSubject(username)
                   .setIssuedAt(new Date(System.currentTimeMillis()))
                   .setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
                   .signWith(getSignKey(),SignatureAlgorithm.HS256)
                   .compact();
    }

}
