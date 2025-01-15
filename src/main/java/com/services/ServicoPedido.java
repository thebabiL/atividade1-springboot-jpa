package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Pedido;
import com.repositories.RepositorioPedido;

@Service
public class ServicoPedido
{
  @Autowired
  private RepositorioPedido repositorio;

  public List<Pedido> findAll()
  {
    return repositorio.findAll();
  }

  public Pedido findById(Long id)
  {
    Optional<Pedido> obj = repositorio.findById(id);

    return obj.get();
  }
}
