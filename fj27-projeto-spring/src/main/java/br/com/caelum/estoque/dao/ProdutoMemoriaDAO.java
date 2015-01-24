package br.com.caelum.estoque.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.estoque.model.Produto;

@Repository
@Transactional
public class ProdutoMemoriaDAO implements ProdutoDAO {

	private List<Produto> produtos = new ArrayList<Produto>();

	public List<Produto> listar() {
		return produtos;
	}

	public void salvar(Produto produto) {
		produtos.add(produto);
	}

	public void alterar(Produto produto) {
	}

	public Produto buscarPorId(Long id) {
		return null;
	}

	public void remover(Long id) {
	}

	public Integer estoqueAtual(Produto produto) {
		for (Produto p : produtos) {
			if (p.getId().equals(produto.getId())) {
				return p.getQuantidade();
			}
		}
		throw new IllegalArgumentException("Produto não encontrado");
	}
}