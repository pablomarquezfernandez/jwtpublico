package co.edu.javeriana.security.jwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.security.jwt.dto.TokenDTO;
import co.edu.javeriana.security.jwt.dto.UsuarioDTO;
import co.edu.javeriana.security.jwt.service.JWTTokenService;

@RestController
@RequestMapping(value = "/jwt/security/autenticar")
public class AutenticacionController {

    @Autowired
    JWTTokenService jwtTokenService;

    @CrossOrigin
    @PostMapping(  value = "/autenticar", produces = MediaType.APPLICATION_JSON_VALUE)
    public TokenDTO autenticar( @RequestBody UsuarioDTO usuarioDTO ){
        return new TokenDTO(jwtTokenService.generarToken(usuarioDTO), usuarioDTO);
    }




    @CrossOrigin
    @PostMapping(  value = "/autenticar-correo-contrasena", produces = MediaType.APPLICATION_JSON_VALUE)
    public String autenticar( @RequestParam String correo, @RequestParam String contrasena ){
        UsuarioDTO usuarioDTO = new UsuarioDTO(3, "Pablo", "Marquez", correo);
        return jwtTokenService.generarToken(usuarioDTO);
    }
}
