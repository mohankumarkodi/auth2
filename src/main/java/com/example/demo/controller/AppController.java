package com.example.demo.controller;

import com.example.demo.Dto.LoginDto;
import com.example.demo.Exceptions.InvalidCredentialsException;

import lombok.var;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;

import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@CrossOrigin("*")
public class AppController {


    private final OAuth2AuthorizedClientService authorizedClientService;

    public AppController(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }


    @GetMapping("/")
    public String dashboard(){
        return "home";
    }

    @GetMapping("/google")
    public String getEmailFromToken(Authentication authentication) {
        final var authorizedClient = authorizedClientService.loadAuthorizedClient("cognito", "catalin");
        if (Objects.nonNull(authorizedClient)) {
            final var accessToken = authorizedClient.getAccessToken();
            return accessToken.getTokenValue();
        }
        return "no access token for user";
//        if (authentication != null && authentication.getPrincipal() instanceof OidcUser) {
//            OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
//            OidcIdToken idToken = oidcUser.getIdToken();
//            System.out.println(idToken.getTokenValue());
//             return ( oidcUser.getEmail());
//        }
//        return null;
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