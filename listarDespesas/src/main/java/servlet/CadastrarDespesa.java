package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Categoria;
import model.Despesa;
import persistence.DespesaRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = "/cadastrarDespesa")
public class CadastrarDespesa extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        var enviar = req.getParameter("enviar");
        var voltar = req.getParameter("voltar");

        if(voltar != null)
            req.getRequestDispatcher("/index.jsp").forward(req, resp);

        DespesaRepository despesaRepository = DespesaRepository.despesaRepository;
        String descricao = req.getParameter("descricao");
        String dataStr = req.getParameter("data");
        String valorStr = req.getParameter("valor");
        String categoriaStr = req.getParameter("categoria");

        LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        BigDecimal valor = BigDecimal.valueOf(Double.parseDouble(valorStr));
        Categoria categoria = Categoria.valueOf(categoriaStr);
        long id = despesaRepository.getUtimoId() + 1;
        Despesa despesa = new Despesa(id, descricao, data, valor, categoria);
        despesaRepository.salvarDespesa(despesa);
        req.getRequestDispatcher("/cadastrar.jsp").include(req, resp);
        out.println("<h2>Despesa de %s no valor de %s foi cadastrada com sucesso</h2>"
                .formatted(despesa.getDescricao(), despesa.getValor()));

        System.out.println(despesaRepository.buscarDespesas());

    }
}
