package com.patriciasantos.desafio.services;

import org.springframework.stereotype.Service;

import com.patriciasantos.desafio.repositories.FilmeRepository;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;


    public FilmeService(final FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

}
