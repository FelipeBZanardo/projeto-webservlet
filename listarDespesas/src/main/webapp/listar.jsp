<%@ page import="persistence.DespesaRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Lista de Despesas</title>
  <style>
    table {
      font-family: arial, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }

    td, th {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }

    tr:nth-child(even) {
      background-color: #dddddd;
    }
  </style>
</head>
<body>
    <form action="index.jsp" method="POST">
    <table>
      <tr>
        <th>Descrição</th>
        <th>Data</th>
        <th>Valor(R$)</th>
        <th>Categoria</th>
      </tr>
        <c:forEach var="despesa" items="${DespesaRepository.despesaRepository.buscarDespesas()}">
            <tr>
                <td>${despesa.getDescricao()}</td>
                <td><fmt:parseDate value="${despesa.getData()}" pattern="yyyy-MM-dd" var="data" type="date"/>
                <fmt:formatDate value="${data}" type="date" pattern="dd/MM/yyyy"/></td>
                <td><fmt:formatNumber value="${despesa.getValor()}" minFractionDigits="2" type="currency" currencySymbol="R$"/></td>
                <td>${despesa.getCategoria()}</td>
                <td><a href="/Despesas/controladora?acao=RemoveDespesa&id=${despesa.getId()}">Remover</a></td>
            </tr>
        </c:forEach>
    </table>
      <input name="voltar" type="submit" value="Voltar">
    </form>

</body>
</html>
