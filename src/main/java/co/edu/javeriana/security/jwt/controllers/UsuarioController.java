package co.edu.javeriana.security.jwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.security.jwt.dto.UsuarioDTO;
import co.edu.javeriana.security.jwt.service.UsuarioService;

@RestController
@RequestMapping(value = "/jwt/security/usuario")
public class UsuarioController {


    @Autowired
    UsuarioService usuarioService;


    @CrossOrigin
    @GetMapping(  produces = MediaType.APPLICATION_JSON_VALUE )
    public UsuarioDTO autenticar( Authentication authentication ) throws Exception{
        System.out.println( authentication );
        return usuarioService.autorizacion(authentication);
    }


    @CrossOrigin
    @GetMapping(  value = "/error", produces = MediaType.APPLICATION_JSON_VALUE )
    public UsuarioDTO error( Authentication authentication ) throws Exception{
        System.out.println( authentication );
        return usuarioService.autorizacion(authentication);
    }
}
