package com.HouseBeer.controller;

import com.HouseBeer.entity.Usuario;
import com.HouseBeer.security.payload.LoginPayload;
import com.HouseBeer.DTO.AuthTokenDto;
import com.HouseBeer.security.jwt.JwtTokenUtil;
import com.HouseBeer.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private  JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginPayload loginPayload){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginPayload.getName() ,
                        loginPayload.getPassword()
                )
        );
     
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new AuthTokenDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario user){
        if(usuarioService.findByUserName(user.getNombre()) != null){
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }
        if(usuarioService.findByEmail(user.getEmail()) != null){
            return ResponseEntity.badRequest().body("El Email ya existe");
        }


        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        usuarioService.saveRol(user);

        return ResponseEntity.ok("Usuario creado");
    }



}
