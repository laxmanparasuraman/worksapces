package com.laxman.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class JwtProvider {
    private  static SecretKey key=Keys.hmacShaKeyFor(JwtConstant.SECREATE_KEY.getBytes());// need to checi
    public static  String generateToken(Authentication auth){
        Collection <? extends GrantedAuthority> authorities=auth.getAuthorities();
        String roles =populateAuthorities(authorities);
        String jwt = Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date( new Date().getTime()+8400000))
                .claim("email",auth.getName())
                .claim("authorities",roles)
                .signWith(key)
                .compact();


        return  jwt;

    }
    public  static String getEmailFromToken(String token){
        token=token.substring(7);
        Claims claims = Jwts.parser().setSigningKey(key).build()                   // Build the parser
                .parseClaimsJws(token)       // Parse the JWT
                .getBody();
        String  email= String.valueOf(claims.get("email"));
      //  String authorities =String.valueOf(claims.get("authorities"));
    return  email;

    }


    private  static  String populateAuthorities(Collection <? extends GrantedAuthority> authorities){
        Set<String> auth =new HashSet<>();
        for (GrantedAuthority ga:authorities){
            auth.add(ga.getAuthority());

        }
        return String.join(",",auth);

    }

}
