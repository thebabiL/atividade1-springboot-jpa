package com.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario 
{
  @GetMapping
   public ResponseEntity<Usuario> encontrarTodos()
   {
      Usuario u = new Usuario(1L, "Maria", "maria@gmail.com", "9999999", "12345");
      return ResponseEntity.ok().body(u);
   }
}
