package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.entities.Usuario;
import com.repositories.RepositorioUsuario;
import com.services.exceptions.ExceptionBancoDados;
import com.services.exceptions.ExceptionRecursoNaoEncontrado;

@Service
public class ServicoUsuario 
{
  @Autowired
  private RepositorioUsuario repositorio;

  public List<Usuario> findAll()
  {
    return repositorio.findAll();
  }

  public Usuario findById(Long id)
  {
    Optional<Usuario> obj = repositorio.findById(id);
    return obj.orElseThrow(() -> new ExceptionRecursoNaoEncontrado(id));
  }

  public Usuario inserir(Usuario obj)
  {
    return repositorio.save(obj);
  }

  public void deletar(Long id)
  {
    try
    {
    // Verificar se o ID existe antes de deletar
      if (!repositorio.existsById(id)) 
      {
        throw new ExceptionRecursoNaoEncontrado(id); // Lança a exceção se não encontrar o ID
      }
      repositorio.deleteById(id);
     }
    catch(EmptyResultDataAccessException e)
    {
      throw new ExceptionRecursoNaoEncontrado(id);
    }
    catch(DataIntegrityViolationException e)
    {
      throw new ExceptionBancoDados(e.getMessage());
    }
  }

  public Usuario atualizar(Long id, Usuario obj)
  {
    Usuario entidade = repositorio.getReferenceById(id);
    atualizarDados(entidade, obj);
    return repositorio.save(entidade);
  }

  private void atualizarDados(Usuario entidade, Usuario obj)
  {
    entidade.setNome(obj.getNome());
    entidade.setEmail(obj.getEmail());
    entidade.setTelefone(obj.getTelefone());
  }
}