package com.patriciasantos.desafio.repositories;

import org.springframework.stereotype.Repository;

import com.patriciasantos.desafio.models.Voto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long>  {

}
