<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Produto</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />

	<form action="alterar" method="post">
		<input type="hidden" name="id" value="${produto.id}" /><br />
		Descrição: <input type="text" name="descricao"
			value="${produto.descricao}" /><br /> Quantidade: <input
			type="text" name="quantidade" value="${produto.quantidade}" /><br />
		<input type="submit" value="Alterar">
	</form>

	<c:import url="rodape.jsp" />
</body>
</html>