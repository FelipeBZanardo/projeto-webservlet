package acoes;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Acao {
    void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
