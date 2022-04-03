package br.com.renanjpa.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private BigDecimal precoUnitario;
	private Integer quantidade;
	
	@ManyToOne
	Produto produto;

	@ManyToOne
	Pedido pedido;
	
	public ItemPedido() {
	}
	
	public ItemPedido(Produto produto, Pedido pedido, Integer quantidade ) {
		super();
		this.quantidade = quantidade;
		this.produto = produto;
		this.pedido = pedido;
		this.precoUnitario = produto.getPreco();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
