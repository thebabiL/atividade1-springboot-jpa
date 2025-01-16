package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Produto;
import com.repositories.RepositorioProduto;

@Service
public class ServicoProduto
{
  @Autowired
  private RepositorioProduto repositorio;

  public List<Produto> findAll()
  {
    return repositorio.findAll();
  }

  public Produto findById(Long id)
  {
    Optional<Produto> obj = repositorio.findById(id);

    return obj.get();
  }
}
