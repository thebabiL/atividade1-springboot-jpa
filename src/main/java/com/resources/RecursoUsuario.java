package com.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

   @GetMapping(value = "/{id}")
   public ResponseEntity<Usuario> findById(@PathVariable Long id)
   {
      Usuario obj = servico.findById(id);

      return ResponseEntity.ok().body(obj);
   }

   @PostMapping
   public ResponseEntity<Usuario> inserir(@RequestBody Usuario obj)
   {
      obj = servico.inserir(obj);
      return ResponseEntity.ok().body(obj);
   }
   
}
