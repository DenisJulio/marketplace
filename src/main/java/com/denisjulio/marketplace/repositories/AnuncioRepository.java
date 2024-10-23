package com.denisjulio.marketplace.repositories;

import org.springframework.data.repository.CrudRepository;

import com.denisjulio.marketplace.entities.Anuncio;

public interface AnuncioRepository extends CrudRepository<Anuncio, Integer> {
}
