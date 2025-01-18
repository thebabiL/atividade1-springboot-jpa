package com.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.services.exceptions.ExceptionResursoNaoEncontrado;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionManipuladorRecurso 
{
  @ExceptionHandler(ExceptionResursoNaoEncontrado.class)
  public ResponseEntity<ErroPadrao> recursoNaoEncontrado(ExceptionResursoNaoEncontrado e, HttpServletRequest request)
  {
    String erro = "Recurso não encontrado!";
    HttpStatus status = HttpStatus.NOT_FOUND;
    ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(erroPadrao);
  }
}
