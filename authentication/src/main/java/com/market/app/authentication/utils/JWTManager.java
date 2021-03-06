package com.market.app.authentication.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.market.app.authentication.utils.Constants.JWTConfig.*;

@Configuration
public class JWTManager {

    public String getJWTToken(String username, String subsidiary) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_ADMIN");

        return Jwts
                .builder()
                .setId("SIGNEDJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .claim("subsidiary",subsidiary)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 6000000))
                .signWith(SignatureAlgorithm.HS512,
                        SECRET.getBytes()).compact();
    }

    public String getUsernameInToken(HttpServletRequest request){
        String jwtToken = request.getHeader(AUTHORIZATION_HEADER_NAME).replace(BEARER_PREFIX_HEADER, "");
        return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody().getSubject();
    }

    public String getSubsidiary(HttpServletRequest request){
        String jwtToken = request.getHeader(AUTHORIZATION_HEADER_NAME).replace(BEARER_PREFIX_HEADER, "");
        return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody().get("subsidiary").toString();
    }
}
