package br.com.renanjpa.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.renanjpa.loja.modelo.Categoria;

public class CategoriaDAO {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");
	private EntityManager em;
		
	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Categoria categoria) {
		em.persist(categoria);
	}

}
