package br.com.caelum.estoque;

import java.util.List;

import br.com.caelum.estoque.dao.ProdutoDAO;

public class GerenciadorDeProduto {

	private ProdutoDAO produtoDao;

//	public GerenciadorDeProduto(ProdutoDAO produtoDao) {
//		this.produtoDAO = produtoDao;
//	}

	public void novoProduto(Produto produto) {
		System.out.println("Salvando produto.");
		this.produtoDao.salvar(produto);
	}

	public void setProdutoDAO(ProdutoDAO produtoDao) {
		this.produtoDao = produtoDao;
	}

	public List<Produto> getProdutos() {
		return produtoDao.listar();
	}
}
