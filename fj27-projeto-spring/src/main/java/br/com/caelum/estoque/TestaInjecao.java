package br.com.caelum.estoque;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestaInjecao {

	public static void main(String[] args) {

		// cria o contexto do Spring
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		// obt�m o gerenciador
		GerenciadorDeProduto gerenciador = context.getBean(
				"gerenciadorProduto", GerenciadorDeProduto.class);

		// cria um Produto como se o usu�rio tivesse preenchido um formul�rio
		Produto produto = new Produto();
		produto.setDescricao("Livro Spring in Action");
		produto.setQuantidade(10);

		// chama a l�gica e v� o resultado
		gerenciador.novoProduto(produto);

		// verifica que o produto foi adicionao ao nosso dao em memoria
		for (Produto p : gerenciador.getProdutos()) {
			System.out.println("Descricao: " + p.getDescricao());
			System.out.println("Quantidade: " + p.getQuantidade());
		}
	}
}