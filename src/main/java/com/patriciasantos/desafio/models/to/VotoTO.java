package com.patriciasantos.desafio.models.to;

import java.io.Serializable;

import com.patriciasantos.desafio.models.Voto;

public class VotoTO implements Serializable {

    private Integer nota;
    private Long idFilme;


    public VotoTO() {
    }


    public VotoTO(final Voto voto) {
        this.nota = voto.getNota();
        this.idFilme = voto.getFilme().getId();
    }


    public Integer getNota() {
        return this.nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }


    public Long getIdFilme() {
        return idFilme;
    }


    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    } 


}
