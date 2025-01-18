package com.services.exceptions;

public class ExceptionRecursoNaoEncontrado extends RuntimeException
{
  private static final long serialVersionUID = 1L;

  public ExceptionRecursoNaoEncontrado(Object id)
  {
    super("Recurso não encontrado. Id: " + id);
  }
}
