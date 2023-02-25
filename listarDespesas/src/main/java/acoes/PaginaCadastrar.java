package acoes;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class PaginaCadastrar implements Acao{
    @Override
    public RequestDispatcher executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return req.getRequestDispatcher("/cadastrar.jsp");
    }
}
