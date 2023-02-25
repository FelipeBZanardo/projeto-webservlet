package acoes;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
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

public class AdicionaDespesa implements Acao {
    @Override
    public RequestDispatcher executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

        String mensagem = "Despesa de %s no valor de %s foi cadastrada com sucesso"
                .formatted(despesa.getDescricao(), despesa.getValor());

        req.setAttribute("mensagem", mensagem);
        resp.setHeader("mensagem", mensagem);

        return req.getRequestDispatcher("/cadastrar.jsp");

    }
}
