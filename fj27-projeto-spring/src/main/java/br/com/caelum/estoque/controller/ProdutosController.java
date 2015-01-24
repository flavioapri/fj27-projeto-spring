package br.com.caelum.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.estoque.dao.MovimentacaoDAO;
import br.com.caelum.estoque.dao.ProdutoDAO;
import br.com.caelum.estoque.model.Movimentacao;
import br.com.caelum.estoque.model.Produto;

@Controller
@RequestMapping(value = "produtos") 
public class ProdutosController {

	@Autowired
	@Qualifier("produtoHibernateDAO")
	private ProdutoDAO produtoDAO;

	@Autowired
	private GeradorDeMovimentacao geradorDeMovimentacao;
	
	@Autowired
	private MovimentacaoDAO movimentacaoDAO;
	
	@RequestMapping(value = "index")
	public String index() {
		return "produtos/index";
	}

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject(produtoDAO.listar());
		return modelAndView;
	}

	@RequestMapping(value = "mostrar/{id}", method = RequestMethod.GET)
	public ModelAndView mostrar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("produtos/mostrar");
		modelAndView.addObject(produtoDAO.buscarPorId(id));
		return modelAndView;
	}

	@RequestMapping(value = "form")
	public String form() {
		return "produtos/form";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(Produto produto) {
		produtoDAO.salvar(produto);
		return "redirect:/produtos/listar";
	}

	@Transactional
	@RequestMapping(value = "alterar", method = RequestMethod.POST)
	public String alterar(Produto produto) {
		Movimentacao movimentacao = geradorDeMovimentacao.geraMovimentacao(produto);
		movimentacaoDAO.salvar(movimentacao);
		produtoDAO.alterar(produto);
		return "redirect:/produtos/listar";
	}

	@RequestMapping(value = "editar", method = RequestMethod.GET)
	public ModelAndView editar(Long id) {
		Produto produto = produtoDAO.buscarPorId(id);
		ModelAndView modelAndView = new ModelAndView("produtos/editar");
		modelAndView.addObject(produto); 
		return modelAndView;
	}
	
	@RequestMapping(value = "remover", method = RequestMethod.GET)
	public String remover(Long id) {
		produtoDAO.remover(id);
		return "redirect:/produtos/listar";
	}
}
