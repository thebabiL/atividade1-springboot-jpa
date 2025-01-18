package com.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.services.exceptions.ExceptionBancoDados;
import com.services.exceptions.ExceptionRecursoNaoEncontrado;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionManipuladorRecurso 
{
  @ExceptionHandler(ExceptionRecursoNaoEncontrado.class)
  public ResponseEntity<ErroPadrao> recursoNaoEncontrado(ExceptionRecursoNaoEncontrado e, HttpServletRequest request)
  {
    String erro = "Recurso não encontrado!";
    HttpStatus status = HttpStatus.NOT_FOUND;
    ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(erroPadrao);
  }

  @ExceptionHandler(ExceptionBancoDados.class)
  public ResponseEntity<ErroPadrao> bancoDados(ExceptionBancoDados e, HttpServletRequest request)
  {
    String erro = "Erro no Banco de Dados!";
    HttpStatus status = HttpStatus.BAD_REQUEST;
    ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(erroPadrao);
  }
}
