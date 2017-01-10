package br.com.triadworks.javaweb.modelo;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.triadworks.javaweb.dao.UsuarioDAO;

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
			RequestDispatcher rd = request.getRequestDispatcher("/menu.jsp");
			request.setAttribute("usuarioLogado", usuarioAutenticado);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			request.setAttribute("msgUsuario", "Login ou senha inválidos.");
			rd.forward(request, response);
		}
		
		
		
	}
	
	
	
}
