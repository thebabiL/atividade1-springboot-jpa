package com.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Usuario;
import com.services.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario 
{
   @Autowired
   private ServicoUsuario servico;

  @GetMapping
   public ResponseEntity<List<Usuario>> findAll()
   {
      List<Usuario> lista = servico.findAll();
      
      return ResponseEntity.ok().body(lista);
   }
}
