package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Produto;

public interface RepositorioProduto extends JpaRepository<Produto, Long>
{
  
}
