package com.patriciasantos.desafio.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.patriciasantos.desafio.models.enums.PerfilEnum;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "username", length = 100, nullable = false, unique = true)
    @NonNull
    @NotEmpty
    @Size(min = 2, max = 100)
    private String username;

    @JsonProperty( access = Access.WRITE_ONLY)
    @Column(name = "senha", length = 60, nullable = false)
    @NonNull
    @NotEmpty
    @Size(min = 2, max = 60)
    private String senha;

    @Column(name = "ativo", nullable = false)
    @NonNull
    @NotEmpty
    private Boolean ativo = true;

    @JsonProperty( access = Access.WRITE_ONLY)
    @Column(name = "perfil", nullable = false) 
    private Integer perfil;
    

    public Usuario() {

    }

    public Usuario(final Long id, final String username, final String senha) {
        this.id = id;
        this.username = username;
        this.senha = senha;
    } 

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(final String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getPerfil() {
        return perfil;
    }

    public void setPerfil(Integer perfil) {
        this.perfil = perfil;
    }   

    public PerfilEnum getPerfilEnum() {
        return PerfilEnum.toEnum(this.perfil);
    }

    public void setPerfil(final PerfilEnum perfilEnum) {
        this.perfil = perfilEnum.getCodigo();
    }

    public static class UsuarioBuilder {

        private Usuario usuario;

        public UsuarioBuilder create() {
            usuario = new Usuario();
            return this;
        }

        public UsuarioBuilder comUsername(final String username) {
            usuario.setUsername(username);
            return this;
        }

        public UsuarioBuilder comSenha(final String senha) {
            usuario.setSenha(senha);
            return this;
        }

        public UsuarioBuilder comPerfil(final Integer perfil) {
            usuario.setPerfil(perfil);
            return this;
        }

        public Usuario build() {
            return usuario;
        }

    }
    
}

