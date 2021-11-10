package com.market.app.authentication.services;


import com.market.app.authentication.dto.LoginRequestDTO;
import com.market.app.authentication.dto.LoginResponseDTO;
import com.market.app.authentication.utils.JWTManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private JWTManager jwtManager;

    public ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequest){

        //FIND IN DATABASE


        if(loginRequest.getUsuario() != null) {
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
