package br.com.renanjpa.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.renanjpa.loja.modelo.Produto;

public class ProdutoDAO {
	EntityManager em;
	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	public void salvar(Produto p) {
		em.persist(p);
	}
	public Produto buscarPorId(int i) {
		return em.find(Produto.class, 1);
		
	}
	public List<Produto> buscarTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
	public List<Produto> buscaProdutoPorNome(String nome) {
		String jpql = "SELECT p FROM Produto p where p.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	public List<Produto> buscaPorNomeCategoria(String categoria) {
		String jpql = "SELECT p FROM Produto p where p.categoria.nome = :categoria";
		return em.createQuery(jpql, Produto.class)
				.setParameter("categoria", categoria)
				.getResultList();
	}
	public BigDecimal getPrecoPorNome(String nome) {
		String jpql = "SELECT p.preco FROM Produto p where p.nome = :nome";
		return em.createQuery(jpql, BigDecimal.class).setParameter("nome", nome).getSingleResult();
	}

}
