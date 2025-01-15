package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long>
{
  
}
