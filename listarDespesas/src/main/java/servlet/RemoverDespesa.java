package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.DespesaRepository;

import java.io.IOException;

@WebServlet(urlPatterns = "/removerDespesa")
public class RemoverDespesa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        DespesaRepository despesaRepository = DespesaRepository.despesaRepository;
        despesaRepository.deletarDespesa(Long.parseLong(id));

        req.getRequestDispatcher("/listar.jsp").forward(req, resp);

    }
}
