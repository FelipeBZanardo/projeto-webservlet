package acoes;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.DespesaRepository;

import java.io.IOException;

public class RemoveDespesa implements Acao{
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        DespesaRepository despesaRepository = DespesaRepository.despesaRepository;
        despesaRepository.deletarDespesa(Long.parseLong(id));
        req.getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}
