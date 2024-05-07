package com.patriciasantos.desafio.models.to;

import java.io.Serializable;

import com.patriciasantos.desafio.models.Voto;

public class VotoTO implements Serializable {

    private Integer nota;
    private String usuario;


    public VotoTO() {
    }


    public VotoTO(final Voto voto) {
        this.nota = voto.getNota();
        this.usuario = voto.getUsuario().getUsername();
    }


    public Integer getNota() {
        return this.nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


}
