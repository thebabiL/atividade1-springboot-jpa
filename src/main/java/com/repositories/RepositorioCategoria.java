package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long>
{
  
}
