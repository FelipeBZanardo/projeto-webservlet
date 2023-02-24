package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(urlPatterns = "/controladora")
public class Controladora extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        var cadastrar = req.getParameter("cadastrar");
        var listar = req.getParameter("listar");
        var voltar = req.getParameter("voltar");

        if (cadastrar != null)
            req.getRequestDispatcher("/cadastrar.jsp").forward(req, res);

        if (listar != null)
            req.getRequestDispatcher("/listar.jsp").forward(req, res);

        if (voltar != null)
            req.getRequestDispatcher("/index.jsp").forward(req, res);
    }
}
