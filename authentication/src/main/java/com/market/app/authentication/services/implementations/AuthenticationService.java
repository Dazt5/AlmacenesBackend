package com.market.app.authentication.services.implementations;


import com.market.app.authentication.dto.LoginRequestDTO;
import com.market.app.authentication.dto.LoginResponseDTO;
import com.market.app.authentication.entity.User;
import com.market.app.authentication.repository.IUserRepository;
import com.market.app.authentication.utils.JWTManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private JWTManager jwtManager;

    @Autowired
    private IUserRepository userRepository;

    public ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequest){

        //FIND IN DATABASE
        User user = userRepository.findByUsername(loginRequest.getUsuario()).orElse(null);

        if( user != null && loginRequest.getPassword().equals(user.getPassword())) {
            LoginResponseDTO responseDTO = new LoginResponseDTO();
            responseDTO.setMessage("Usuario autenticado correctamente");
            responseDTO.setToken(jwtManager.getJWTToken(loginRequest.getUsuario()));
            return ResponseEntity.ok().body(responseDTO);
        }

        LoginResponseDTO responseDTO = new LoginResponseDTO();
        responseDTO.setMessage("Usuario o contraseña inválida");
        return ResponseEntity.badRequest().body(responseDTO);
    }
}
