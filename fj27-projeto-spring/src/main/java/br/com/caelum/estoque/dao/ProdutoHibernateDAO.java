package br.com.caelum.estoque.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caelum.estoque.model.Produto;

@Repository
public class ProdutoHibernateDAO implements ProdutoDAO {

	private Session session;

	@Autowired
	public ProdutoHibernateDAO(SessionFactory factory) {
		session = factory.openSession();
	}

	public void salvar(Produto produto) {
		session.save(produto);
	}

	public void alterar(Produto produto) {
		session.update(produto);
	}

	public List<Produto> listar() {
		List<Produto> produtos = session.createQuery("from Produto").list();
		return produtos;
	}

	public Produto buscarPorId(Long id) {
		return (Produto) session.get(Produto.class, id);
	}
}
