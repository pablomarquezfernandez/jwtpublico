package co.edu.javeriana.security.jwt.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.javeriana.security.jwt.dto.UsuarioDTO;

@Service
public class UsuarioService {


    // @Autowired
    // UsuarioRepository usuarioRepository;
    @Autowired
	ModelMapper modelMapper;
    

    public UsuarioDTO autorizacion( Authentication authentication ) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("-----------------------");
        System.out.println(  authentication.getName() );
        UsuarioDTO usuario = objectMapper.readValue(authentication.getName(), UsuarioDTO.class);
        System.out.println("-----------------------"); 
        return usuario;
    }
}
