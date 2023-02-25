package servlet;

import acoes.Acao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet(urlPatterns = "/controladora")
public class ControladoraServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            String acao = req.getParameter("acao");
            System.out.println(acao);
            Class<?> classe = Class.forName("acoes." + acao);
            Acao action = (Acao) classe.newInstance();
            action.executar(req, resp).forward(req, resp);
        } catch (Exception e){
            e.printStackTrace();
        }



    }
}
