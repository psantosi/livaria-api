package com.patriciasantos.desafio.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.patriciasantos.desafio.services.FilmeService;

@RestController
public class FilmeController {

    private final FilmeService filmeService;


    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }


}
