package br.com.renanjpa.loja.dao;

import javax.persistence.EntityManager;

import br.com.renanjpa.loja.modelo.Pedido;

public class PedidoDAO {
	EntityManager em;
	public PedidoDAO(EntityManager em) {
		this.em = em;
	}
	public void salvar(Pedido p) {
		em.persist(p);
	}
	public Pedido buscarPorId(int i) {
		return em.find(Pedido.class, 1);
		
	}
}
