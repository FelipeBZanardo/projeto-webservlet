package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import persistence.DespesaRepository;

import java.io.IOException;

@WebServlet(urlPatterns = "/controladora")
public class Controladora extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {


        String cadastrar = req.getParameter("cadastrar");
        String listar = req.getParameter("listar");
        String voltar = req.getParameter("voltar");

        System.out.println(cadastrar);

        if (cadastrar != null)
            req.getRequestDispatcher("/cadastrar.jsp").forward(req, res);

        if (listar != null)
            req.getRequestDispatcher("/listar.jsp").forward(req, res);

        if (voltar != null)
            req.getRequestDispatcher("/index.jsp").forward(req, res);
    }
}
