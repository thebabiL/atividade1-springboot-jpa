package com.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.entities.enums.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable
{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
  private Instant momento;

  private Integer pedidoStatus;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Usuario cliente;

  @OneToMany(mappedBy = "id.pedido")
  private Set<ItemPedido> itens = new HashSet<>();

  @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
  private Pagamento pagamento;

  public Pedido()
  {

  }

  public Pedido(Long id, Instant momento, PedidoStatus pedidoStatus, Usuario cliente) 
  {
    this.id = id;
    this.momento = momento;
    setPedidoStatus(pedidoStatus);
    this.cliente = cliente;
  }

  public Long getId() 
  {
    return id;
  }

  public void setId(Long id) 
  {
    this.id = id;
  }

  public Instant getMomento() 
  {
    return momento;
  }

  public void setMomento(Instant momento) 
  {
    this.momento = momento;
  }

  public PedidoStatus getPedidoStatus() 
  {
    return PedidoStatus.valueOf(pedidoStatus);
  }

  public void setPedidoStatus(PedidoStatus pedidoStatus) 
  {
    if (pedidoStatus != null)
    {
      this.pedidoStatus = pedidoStatus.getCodigo();
    }
  }

  public Usuario getCliente() 
  {
    return cliente;
  }

  public void setCliente(Usuario cliente) 
  {
    this.cliente = cliente;
  }

  public Pagamento getPagamento() 
  {
    return pagamento;
  }

  public void setPagamento(Pagamento pagamento) 
  {
    this.pagamento = pagamento;
  }

  public Set<ItemPedido> getItens()
  {
    return itens;
  }

  @Override
  public int hashCode() 
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) 
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pedido other = (Pedido) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  

  
}
