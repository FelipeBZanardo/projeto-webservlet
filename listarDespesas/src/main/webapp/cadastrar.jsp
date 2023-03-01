<%@ page import="model.Categoria" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Cadastrar Despesa</title>
</head>
<body>
<form action="controladora" method="POST">
  Descrição: <input name="descricao" type="text"><br>
  Data: <input name="data" type="text"><br>
  Valor: R$<input name="valor" type="text"><br>
  Categoria:
  <select name="categoria">
    <c:forEach var="categoria" items="${Categoria.values()}">
      <option><c:out value="${categoria.name()}"/></option>
    </c:forEach>
  </select>
  <br>
  <input name="enviar" type="submit" value="Enviar">
  <input name="acao" type="hidden" value="AdicionaDespesa">
</form>
<form action="index.jsp">
  <input name="voltar" type="submit" value="Voltar">
</form>
<h1>${mensagem}</h1>
</body>
</html>