package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Categoria;
import com.repositories.RepositorioCategoria;

@Service
public class ServicoCategoria 
{
  @Autowired
  private RepositorioCategoria repositorio;

  public List<Categoria> findAll()
  {
    return repositorio.findAll();
  }

  public Categoria findById(Long id)
  {
    Optional<Categoria> obj = repositorio.findById(id);

    return obj.get();
  }
}
