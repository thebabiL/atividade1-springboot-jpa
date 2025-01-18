package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Usuario;
import com.repositories.RepositorioUsuario;

@Service
public class ServicoUsuario 
{
  @Autowired
  private RepositorioUsuario repositorio;

  public List<Usuario> findAll()
  {
    return repositorio.findAll();
  }

  public Usuario findById(Long id)
  {
    Optional<Usuario> obj = repositorio.findById(id);

    return obj.get();
  }

  public Usuario inserir(Usuario obj)
  {
    return repositorio.save(obj);
  }
}
