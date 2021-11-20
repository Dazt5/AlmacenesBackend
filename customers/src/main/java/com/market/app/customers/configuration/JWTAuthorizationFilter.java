package com.market.app.customers.configuration;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.market.app.customers.utils.Constants.JWTConfig.*;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            if (checkToken(request, response)) {
                Claims claims = validateToken(request);
                if (claims.get("authorities") != null) {
                    configurateSpringAuthentication(claims);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }
            chain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
    }

    private void configurateSpringAuthentication(Claims claims) {
        @SuppressWarnings("unchecked")
        List<String> roles = (List<String>) claims.get("authorities");

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
                roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    private Claims validateToken(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION_HEADER_NAME).replace(BEARER_PREFIX_HEADER, "");
        return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(token).getBody();
    }

    private Boolean checkToken(HttpServletRequest request, HttpServletResponse response) {
        String authenticationHeader = request.getHeader(AUTHORIZATION_HEADER_NAME);
        System.out.println("HEADER:" + authenticationHeader);
        return authenticationHeader != null && authenticationHeader.startsWith(BEARER_PREFIX_HEADER);
    }
}
