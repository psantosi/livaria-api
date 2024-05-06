package com.patriciasantos.desafio.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.patriciasantos.desafio.models.Usuario;
import com.patriciasantos.desafio.models.enums.PerfilEnum;
import com.patriciasantos.desafio.repositories.UsuarioRepository;
import com.patriciasantos.desafio.services.exceptions.ObjetoNaoEncontradoException;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
   
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioService(final UsuarioRepository usuarioRepository,
                          final BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Usuario obter(final Long id) {
        final Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new ObjetoNaoEncontradoException("Usuário não encontrado."));
    }


    @Transactional(rollbackOn = Exception.class)
    public void criar(final Usuario usuario) {
        usuario.setId(null);
        usuario.setSenha(this.bCryptPasswordEncoder.encode(usuario.getSenha()));
        usuario.setPerfil(PerfilEnum.USUARIO);
        this.usuarioRepository.save(usuario);
    }

    @Transactional(rollbackOn = Exception.class)
    public void atualizar(final Usuario usuario) {
        final Usuario newUsuario = this.obter(usuario.getId());
        newUsuario.setSenha(this.bCryptPasswordEncoder.encode(usuario.getSenha()));
        this.usuarioRepository.save(newUsuario);
    }
    
}