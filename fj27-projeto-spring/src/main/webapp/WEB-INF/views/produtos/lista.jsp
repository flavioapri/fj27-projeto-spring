<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Produtos</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />

	<b>Lista de Produtos no Estoque</b>
	<br />
	<br />
	<c:forEach items="${produtoList}" var="produto">
		${produto.descricao} - ${produto.quantidade} -
 		<a href="editar?id=${produto.id}">/ editar /</a>
		<a href="mostrar/${produto.id}">/ detalhes /</a>
		<a href="remover?id=${produto.id}">/ remover /</a>
		<br />
	</c:forEach>

	<c:import url="rodape.jsp" />
</body>
</html>