package com.patriciasantos.desafio.services;

import org.springframework.stereotype.Service;

import com.patriciasantos.desafio.models.Filme;
import com.patriciasantos.desafio.models.Usuario;
import com.patriciasantos.desafio.models.Voto;
import com.patriciasantos.desafio.models.to.VotoTO;
import com.patriciasantos.desafio.repositories.VotoRepository;
import com.patriciasantos.desafio.services.exceptions.AuthorizationException;

@Service
public class VotoService {

    private final VotoRepository votoRepository;
    private final UsuarioService usuarioService;
    private final FilmeService filmeService;


    public VotoService(final VotoRepository votoRepository, final UsuarioService usuarioService, FilmeService filmeService) {
        this.votoRepository = votoRepository;
        this.usuarioService = usuarioService;
        this.filmeService = filmeService;
    }

    public Voto votar(final VotoTO votoTO) {
         if (this.usuarioService.isUsuarioAdmin()) {
            throw new AuthorizationException("Você não tem permissão para voltar nos filmes.");
        }

        final Usuario usuario = this.usuarioService.obterUsuarioLogado();
        final Filme filme = this.filmeService.buscar(votoTO.getIdFilme());

        final Voto voto = new Voto.VotoBuilder().create()
        .comNota(votoTO.getNota())
        .comUsuario(usuario)
        .comFilme(filme)
        .build();

        return this.votoRepository.save(voto);
    }
    
}
