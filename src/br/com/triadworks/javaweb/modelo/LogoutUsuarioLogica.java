package br.com.triadworks.javaweb.modelo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutUsuarioLogica implements Logica {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		
		HttpSession session = request.getSession();
		session.setAttribute("usuarioLogado", null);
		rd.forward(request, response);
	}

}
