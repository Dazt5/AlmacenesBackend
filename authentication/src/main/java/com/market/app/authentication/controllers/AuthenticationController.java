package com.market.app.authentication.controllers;

import com.market.app.authentication.dto.LoginRequestDTO;
import com.market.app.authentication.dto.LoginResponseDTO;
import com.market.app.authentication.entity.Subsidiary;
import com.market.app.authentication.repository.ISubsidiaryRepository;
import com.market.app.authentication.services.implementations.AuthenticationService;
import com.market.app.authentication.utils.JWTManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authService;

     @Autowired
     private JWTManager jwtManager;

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

    @GetMapping("/subsidiary")
    public  ResponseEntity<Subsidiary> getSubsidiary(HttpServletRequest request){

        Subsidiary subsidiary = subsidiaryRepository.findById(jwtManager.getSubsidiary(request)).orElse(null);

        if(subsidiary == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(subsidiary);
    }
}

