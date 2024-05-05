package com.patriciasantos.desafio.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patriciasantos.desafio.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
@Validated
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(final UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    
}