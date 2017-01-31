package br.com.triadworks.javaweb.modelo;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.triadworks.javaweb.dao.UsuarioDAO;

public class AutenticaUsuarioLogica implements Logica {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Usuario usuarioAutenticado = null;
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Connection conexao = (Connection) request.getAttribute("conexao");
		
		UsuarioDAO dao = new UsuarioDAO(conexao);
		usuarioAutenticado = dao.autentica(login, senha);
		
		if(usuarioAutenticado != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuarioAutenticado);
			response.sendRedirect("homepage.jsp");
		} else {
			request.setAttribute("msgUsuario", "Login ou senha inválidos.");
			response.sendRedirect("login.jsp");
		}
	}
}
