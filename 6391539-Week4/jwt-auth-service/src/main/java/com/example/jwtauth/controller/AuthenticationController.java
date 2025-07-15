package com.example.jwtauth.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;

@RestController
public class AuthenticationController {

    private static final String SECRET_KEY = "mysecretkey12345";

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            return ResponseEntity.status(401).body("Missing or invalid Authorization header");
        }

        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded);
        String[] values = credentials.split(":", 2);

        if (values.length != 2 || !values[0].equals("user") || !values[1].equals("pwd")) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }

        String jwt = Jwts.builder()
                .setSubject(values[0])
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
                .compact();

        return ResponseEntity.ok("{"token":"" + jwt + ""}");
    }
}