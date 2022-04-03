package br.com.renanjpa.loja.teste;

import javax.persistence.EntityManager;

import br.com.renanjpa.loja.dao.ClienteDAO;
import br.com.renanjpa.loja.dao.PedidoDAO;
import br.com.renanjpa.loja.dao.ProdutoDAO;
import br.com.renanjpa.loja.modelo.Cliente;
import br.com.renanjpa.loja.modelo.ItemPedido;
import br.com.renanjpa.loja.modelo.Pedido;
import br.com.renanjpa.loja.modelo.Produto;
import br.com.renanjpa.loja.util.JPAUtil;

public class CadastroDePedido {
	public static void main(String[] args) {
		//criar conexao
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		ClienteDAO clienteDao = new ClienteDAO(em);
		Cliente cli = new Cliente("renan", "123");
		PedidoDAO pedidoDao = new PedidoDAO(em);
		Pedido pedido = new Pedido(cli);
		Produto p = produtoDao.buscarPorId(1);
		ItemPedido ip = new ItemPedido(p, pedido, 10);
		pedido.adicionarItem(ip);
		
		//iniciar transacao
		em.getTransaction().begin();
		clienteDao.salvar(cli);
		pedidoDao.salvar(pedido);
		System.out.println(p.getDescricao());
		//salvar pedido, cliente e iten_pedido
		
		//comitar
		em.getTransaction().commit(); 
		//fechar transacao
		em.close();
	}
}
