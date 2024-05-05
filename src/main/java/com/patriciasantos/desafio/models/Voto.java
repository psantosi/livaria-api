package com.patriciasantos.desafio.models;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nota", length = 1, nullable = false)
    @NonNull
    @NotEmpty
    @Size(min = 1, max = 1)
    private Integer nota;

    @ManyToOne
    @JoinColumn(name = "filme_id", nullable = false, updatable = false)
    private Filme filme;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, updatable = false)
    private Usuario usuario;

    public Voto() {
    }

    public Voto(final Long id, final Integer nota, final Filme filme, final Usuario usuario) {
        this.id = id;
        this.nota = nota;
        this.filme = filme;
        this.usuario = usuario;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNota() {
        return this.nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Filme getFilme() {
        return this.filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

}