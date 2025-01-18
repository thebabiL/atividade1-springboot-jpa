package com.services.exceptions;

public class ExceptionBancoDados extends RuntimeException
{
  private static final long serialVersionUID = 1L;

  public ExceptionBancoDados (String msg)
  {
    super(msg); 
  }
}
