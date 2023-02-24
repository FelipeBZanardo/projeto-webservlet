<%@ page import="model.Categoria" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Cadastrar Despesa</title>
</head>
<body>
<form action="cadastrarDespesa" method="POST">
  Descrição: <input name="descricao" type="text"><br>
  Data: <input name="data" type="text"><br>
  Valor: R$<input name="valor" type="text"><br>
  Categoria:
  <select name="categoria">
    <%Categoria[] categorias = Categoria.values();
      for (Categoria categoria : categorias) {

    %>
    <option><%=categoria.name()%></option>
    <%
      }
    %>
  </select>
  <br>
  <input name="enviar" type="submit" value="Enviar">
  <input name="voltar" type="submit" value="Voltar">
</form>
</body>
</html>