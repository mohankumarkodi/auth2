package com.example.demo.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class FirstController {

    @GetMapping("/google")
    public String getEmailFromToken(Authentication authentication) {
        if (authentication != null && authentication.getPrincipal() instanceof OidcUser) {
            OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
            OidcIdToken idToken = oidcUser.getIdToken();
            if (idToken != null) {
                String token = idToken.getTokenValue();
                if (token != null && !token.isEmpty()) {
                    getEmailFromJwtToken(token);
                }
            }
        }
        return null;
    }

    private void getEmailFromJwtToken(String token) {
        Claims claims = Jwts.parser().setSigningKey("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\n").parseClaimsJws(token).getBody();

        System.out.println(claims);
    }



}


//    @GetMapping("/google")
//    public String getEmailFromToken(Authentication authentication) {
//        if (authentication != null && authentication.getPrincipal() instanceof OidcUser) {
//            OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
//            OidcIdToken idToken = oidcUser.getIdToken();
//            if (idToken != null) {
//                String token = idToken.getTokenValue();
//
//                return token;
//            }
//        }
//        return null;
//    }