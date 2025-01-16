package com.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Categoria;
import com.services.ServicoCategoria;


@RestController
@RequestMapping(value = "/categorias")
public class RecursoCategoria 
{
   @Autowired
   private ServicoCategoria servico;

  @GetMapping
   public ResponseEntity<List<Categoria>> findAll()
   {
      List<Categoria> lista = servico.findAll();
      
      return ResponseEntity.ok().body(lista);
   }

   @GetMapping(value = "/{id}")
   public ResponseEntity<Categoria> findById(@PathVariable Long id)
   {
      Categoria obj = servico.findById(id);

      return ResponseEntity.ok().body(obj);
   }
   
}
