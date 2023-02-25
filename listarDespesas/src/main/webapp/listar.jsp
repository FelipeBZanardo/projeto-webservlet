<%@ page import="persistence.DespesaRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Despesa" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form action="controladora" method="POST">
    <table>
      <tr>
        <th>Descrição</th>
        <th>Data</th>
        <th>Valor(R$)</th>
        <th>Categoria</th>
      </tr>
    <%
      DespesaRepository despesaRepository = DespesaRepository.despesaRepository;
      List<Despesa> despesas = despesaRepository.buscarDespesas();
      for (Despesa despesa : despesas) {
    %>
      <tr>
        <td><%=despesa.getDescricao()%></td>
        <td><%=despesa.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))%></td>
        <td><%=despesa.getValor()%></td>
        <td><%=despesa.getCategoria()%></td>
        <td><a href="/Despesas/controladora?acao=RemoveDespesa&id=<%=despesa.getId()%>">Remover</a></td>
      </tr>
    <%
      }
    %>
    </table>
      <input name="voltar" type="submit" value="Voltar">
        <input name="acao" type="hidden" value="MostraMenu">
    </form>

</body>
</html>
