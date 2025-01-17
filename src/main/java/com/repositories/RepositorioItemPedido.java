package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.ItemPedido;

public interface RepositorioItemPedido extends JpaRepository<ItemPedido, Long>
{
  
}
