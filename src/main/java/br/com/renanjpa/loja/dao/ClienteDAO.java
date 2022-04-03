package br.com.renanjpa.loja.dao;

import javax.persistence.EntityManager;

import br.com.renanjpa.loja.modelo.Cliente;

public class ClienteDAO {
	EntityManager em;
	public ClienteDAO(EntityManager em) {
		this.em = em;
	}
	public void salvar(Cliente c) {
		em.persist(c);
	}
	public Cliente buscarPorId(int i) {
		return em.find(Cliente.class, 1);
		
	}
}
