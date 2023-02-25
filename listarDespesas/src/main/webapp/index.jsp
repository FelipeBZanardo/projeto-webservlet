<%@ page import="model.Categoria" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Controle de Despesas</title>
</head>
<body>
    <form action="controladora">
        <input name="cadastrar" type="submit" value="Cadastrar">
        <input name="acao" type="hidden" value="PaginaCadastrar">
    </form>
    <form action="controladora">
        <input name="listar" type="submit" value="Listar">
        <input name="acao" type="hidden" value="ListaDespesa">
    </form>

</body>
</html>