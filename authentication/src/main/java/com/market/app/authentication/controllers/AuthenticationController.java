package com.market.app.authentication.controllers;

import com.market.app.authentication.dto.LoginRequestDTO;
import com.market.app.authentication.dto.LoginResponseDTO;
import com.market.app.authentication.entity.Subsidiary;
import com.market.app.authentication.repository.ISubsidiaryRepository;
import com.market.app.authentication.services.implementations.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private ISubsidiaryRepository subsidiaryRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest){
        return authService.login(loginRequest);
    }

    @GetMapping("/subsidiaries")
    public ResponseEntity<List<Subsidiary>> getSubsidiaries(){
        return ResponseEntity.ok().body(subsidiaryRepository.findAll());
    }
}

