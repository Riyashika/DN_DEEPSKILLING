package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
@RestController
@Slf4j
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization")
                                            String authHeader) {
        log.info("start authenticate()");
        log.debug("Authorization header :", authHeader);
        Map<String, String> map = new HashMap<>();
        String user = getUser(authHeader);
        String token = jwtService.generateToken(user);
        map.put("token", token);
        log.info("End Authenticate()");
        return map;
    }

    private String getUser(String authHeader) {
        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedCredentials = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedCredentials);
        String user = decodedString.split(":")[0];
        log.debug("Decoded user:", user);
        return user;
    }

}