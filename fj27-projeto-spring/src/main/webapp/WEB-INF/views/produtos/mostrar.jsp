<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhes do Produto</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />

	Id:
	<input value="${produto.id}" disabled="disabled" />
	<br /> Descricao:
	<input value="${produto.descricao}" disabled="disabled" />
	<br /> Quantidade:
	<input value="${produto.quantidade}" disabled="disabled" />

	<h2>Lista de Movimenta��es</h2>
	<ul>
		<c:forEach items="${produto.movimentacoes}" var="m">
			<li>${m.tipo}- ${m.quantidade} - <fmt:formatDate
					value="${m.data.time}" pattern="dd/MM/yyyy - hh:mm" />
			</li>
		</c:forEach>
	</ul>

	<c:import url="rodape.jsp" />
</body>
</html>