package acoes;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.DespesaRepository;

import java.io.IOException;

public class RemoveDespesa implements Acao{
    @Override
    public RequestDispatcher executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        DespesaRepository despesaRepository = DespesaRepository.despesaRepository;
        despesaRepository.deletarDespesa(Long.parseLong(id));
        return req.getRequestDispatcher("/listar.jsp");
    }
}
