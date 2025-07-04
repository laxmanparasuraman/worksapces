package com.laxman.config;




import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsBuilder;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//package com.laxman.config;

public class JwtTokenValidator extends OncePerRequestFilter   {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt =request.getHeader(JwtConstant.JWT_HEADER);

        //Bearer token
        if (jwt!=null){
            jwt=jwt.substring(7);


        try {
            SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECREATE_KEY.getBytes());
            Claims claims = Jwts.parser().setSigningKey(key).build()                   // Build the parser
                    .parseClaimsJws(jwt)       // Parse the JWT
                    .getBody();
            String  email= String.valueOf(claims.get("email"));
            String authorities =String.valueOf(claims.get("authorities"));
   List<GrantedAuthority> authoritiesList = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);

            Authentication auth=new UsernamePasswordAuthenticationToken(
                    email,
                    null,
                    authoritiesList
            );
            SecurityContextHolder.getContext().setAuthentication(auth);

        }catch (Exception e){
            throw  new RuntimeException("invalid token ...");
        }
        }
     filterChain.doFilter(request,response);
    }


}
