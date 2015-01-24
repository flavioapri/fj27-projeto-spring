package br.com.caelum.estoque.dao;

import java.util.List;

import br.com.caelum.estoque.model.Produto;

public interface ProdutoDAO {

	void salvar(Produto produto);
	void alterar(Produto produto);
	void remover(Long id);
	List<Produto> listar();
	Produto buscarPorId(Long id);
	Integer estoqueAtual(Produto produto);
}
