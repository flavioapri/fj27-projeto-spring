<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Produtos</title>
</head>
<body>
	<form action="salvar" method="post">
		<label for="Descricao">Descri��o: </label>
		<input type="text" id="Descricao" name="descricao" /><br />
		<label for="Quantidade">Quantidade: </label>
		<input type="text" id="Quantidade" name="quantidade" />
		<input type="submit" value="Cadastrar" > 
	</form>
</body>
</html>