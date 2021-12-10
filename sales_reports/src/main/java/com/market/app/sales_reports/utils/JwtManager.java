package com.market.app.sales_reports.utils;

import io.jsonwebtoken.Jwts;
import org.springframework.context.annotation.Configuration;;
import javax.servlet.http.HttpServletRequest;


import static com.market.app.sales_reports.utils.Constants.JWTConfig.*;

@Configuration
public class JWTManager {

    public String getSubsidiary(HttpServletRequest request){
        String jwtToken = request.getHeader(AUTHORIZATION_HEADER_NAME).replace(BEARER_PREFIX_HEADER, "");
        return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody().get("subsidiary").toString();
    }
}
