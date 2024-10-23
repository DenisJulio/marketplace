package com.denisjulio.marketplace.repositories;

import org.springframework.data.repository.CrudRepository;

import com.denisjulio.marketplace.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
}
