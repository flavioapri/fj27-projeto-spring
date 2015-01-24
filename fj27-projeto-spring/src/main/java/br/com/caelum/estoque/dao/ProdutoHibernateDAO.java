package br.com.caelum.estoque.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.estoque.model.Produto;

@Repository
@Transactional
public class ProdutoHibernateDAO implements ProdutoDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public ProdutoHibernateDAO(SessionFactory factory) {
		sessionFactory = factory;
	}

	public void salvar(Produto produto) {
		sessionFactory.getCurrentSession().save(produto);
	}

	public void alterar(Produto produto) {
		sessionFactory.getCurrentSession().update(produto);
	}

	public List<Produto> listar() {
		List<Produto> produtos = sessionFactory.getCurrentSession()
				.createQuery("from Produto").list();
		return produtos;
	}

	public Produto buscarPorId(Long id) {
		return (Produto) sessionFactory.getCurrentSession().get(Produto.class,
				id);
	}

	public void remover(Long id) {
		Produto produto = (Produto) sessionFactory.getCurrentSession().load(
				Produto.class, id);
		sessionFactory.getCurrentSession().delete(produto);
	}

	public Integer estoqueAtual(Produto produto) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select quantidade from Produto where id = :pid");
		query.setParameter("pid", produto.getId());
		return (Integer) query.uniqueResult();
	}
}
