package main.java.triadworks.javaweb.modelo;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.triadworks.javaweb.dao.UsuarioDAO;

public class AutenticaUsuarioLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Usuario usuarioAutenticado = null;
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Connection conexao = (Connection) request.getAttribute("conexao");
		
		UsuarioDAO dao = new UsuarioDAO(conexao);
		usuarioAutenticado = dao.autentica(login, senha);
		
		if(usuarioAutenticado != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
			
			request.setAttribute("nome", "RequestScope");
			HttpSession session = request.getSession();
			session.setAttribute("nome", "SessionScope");
			session.setAttribute("usuarioLogado", usuarioAutenticado);
			rd.forward(request, response);
		} else {
			request.setAttribute("msgUsuario", "Login ou senha inválidos.");
			response.sendRedirect("login.jsp");
		}
	}
}
