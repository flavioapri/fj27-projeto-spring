package br.com.caelum.estoque.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.caelum.estoque.Produto;

@Component
public class ProdutoMemoriaDAO implements ProdutoDAO {

	private List<Produto> produtos = new ArrayList<Produto>();

	public void salvar(Produto produto) {
		produtos.add(produto);
	}

	public void alterar(Produto produto) {
	}

	public List<Produto> listar() {
		return produtos;
	}

	public Produto buscarPorId(Long id) {
		return produtos.get(id.intValue() - 1);
	}
}
