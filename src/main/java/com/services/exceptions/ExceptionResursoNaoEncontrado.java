package com.services.exceptions;

public class ExceptionResursoNaoEncontrado extends RuntimeException
{
  private static final long serialVersionUID = 1L;

  public ExceptionResursoNaoEncontrado(Object id)
  {
    super("Recurso não encontrado. Id: " + id);
  }
}
