package com.config;

import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.entities.Categoria;
import com.entities.Pedido;
import com.entities.ItemPedido;
import com.entities.Pagamento;
import com.entities.Produto;
import com.entities.Usuario;
import com.entities.enums.PedidoStatus;
import com.repositories.RepositorioCategoria;
import com.repositories.RepositorioItemPedido;
import com.repositories.RepositorioPedido;
import com.repositories.RepositorioProduto;
import com.repositories.RepositorioUsuario;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner
{
  @Autowired
  private RepositorioUsuario repositorioUsuario;

  @Autowired
  private RepositorioPedido repositorioPedido;

  @Autowired
  private RepositorioCategoria repositorioCategoria;
  
  @Autowired
  private RepositorioProduto repositorioProduto;

  @Autowired
  private RepositorioItemPedido repositorioItemPedido;
  
  @Override
  public void run(String... args) throws Exception 
  {
    Categoria cat1 = new Categoria(null, "Eletrônicos");
    Categoria cat2 = new Categoria(null, "Livros");
    Categoria cat3 = new Categoria(null, "Computadores");

    Produto pro1 = new Produto(null, "O Senhor dos Anéis", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
    Produto pro2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
    Produto pro3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
    Produto pro4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
    Produto pro5 = new Produto(null, "Rails para Leigos", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

    repositorioCategoria.saveAll(Arrays.asList(cat1, cat2, cat3));
    repositorioProduto.saveAll(Arrays.asList(pro1, pro2, pro3, pro4, pro5));

    pro1.getCategorias().add(cat2);
    pro2.getCategorias().add(cat1);
    pro2.getCategorias().add(cat3);
    pro3.getCategorias().add(cat3);
    pro4.getCategorias().add(cat3);
    pro5.getCategorias().add(cat2);

    repositorioProduto.saveAll(Arrays.asList(pro1, pro2, pro3, pro4, pro5));

    Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
    Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

    Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1);
    Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u2);
    Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.ENVIADO, u1);

  
    repositorioUsuario.saveAll(Arrays.asList(u1, u2));
    repositorioPedido.saveAll(Arrays.asList(p1, p2, p3));

    ItemPedido pi1 = new ItemPedido(p1, pro1, 2, pro1.getPreco());
    ItemPedido pi2 = new ItemPedido(p1, pro3, 1, pro3.getPreco());
    ItemPedido pi3 = new ItemPedido(p2, pro3, 2, pro3.getPreco());
    ItemPedido pi4 = new ItemPedido(p3, pro5, 2, pro5.getPreco()); 

    repositorioItemPedido.saveAll(Arrays.asList(pi1, pi2, pi3, pi4));

    Pagamento pag1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), p1);
    p1.setPagamento(pag1);

    repositorioPedido.save(p1);
  }
}
