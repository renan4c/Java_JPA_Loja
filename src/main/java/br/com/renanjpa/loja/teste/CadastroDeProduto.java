package br.com.renanjpa.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.renanjpa.loja.dao.CategoriaDAO;
import br.com.renanjpa.loja.dao.ProdutoDAO;
import br.com.renanjpa.loja.modelo.Categoria;
import br.com.renanjpa.loja.modelo.Produto;
import br.com.renanjpa.loja.util.JPAUtil;

public class CadastroDeProduto {
	public static final EntityManager em = JPAUtil.getEntityManager();
	public static void main(String[] args) {
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		insereCategoriaProduto(produtoDao);
//		Produto prod = produtoDao.buscarPorId(1);
//		System.out.println(prod.getNome());
		
//		BUSCA TODOS PRODUTOS
//		List<Produto> produtos = produtoDao.buscarTodos();
//		produtos.forEach(p -> System.out.println(p.getNome()));
//		
//		BUSCA POR NOME
//		List<Produto> p = produtoDao.buscaProdutoPorNome("celular");
//		p.forEach(p2 -> System.out.println(p2.getNome()));
		
//		BUSCA POR NOME CATEGORIA
//		List<Produto> p = produtoDao.buscaPorNomeCategoria("Eletrônicos");
//		p.forEach(p2 -> System.out.println(p2.getNome()));

//		BUSCAR UM ITEM UMA LINHA
//		BigDecimal preco = produtoDao.getPrecoPorNome("celular");
//		System.out.println(preco);
		
		
		em.close();
	}

	private static void insereCategoriaProduto(ProdutoDAO produtoDao) {
		Categoria categoria = new Categoria("Eletrônicos");
		Produto produto = new Produto("notebook", "acer", new BigDecimal("5000"), categoria);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		em.getTransaction().begin();
		categoriaDao.salvar(categoria);
		produtoDao.salvar(produto);
		em.getTransaction().commit();
		
	}
}

