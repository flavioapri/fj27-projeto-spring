package br.com.caelum.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.estoque.dao.ProdutoDAO;
import br.com.caelum.estoque.model.Produto;

@Controller
@RequestMapping(value = "produtos")
public class ProdutosController {

	@Autowired
	@Qualifier("produtoHibernateDAO")
	private ProdutoDAO produtoDAO;
	
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
}
