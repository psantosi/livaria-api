package com.patriciasantos.desafio.services;

import org.springframework.stereotype.Service;

import com.patriciasantos.desafio.models.Usuario;
import com.patriciasantos.desafio.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
   
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(final UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Transactional(rollbackOn = Exception.class)
    public void criar(final Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    @Transactional(rollbackOn = Exception.class)
    public void atualizar(final Usuario usuario) {
        // final Usuario usuario = this.usuarioRepository.findById(usuario.getId())
    }
    
}