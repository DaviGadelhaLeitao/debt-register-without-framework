package br.com.triadworks.javaweb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.triadworks.javaweb.dao.CaloteiroDAO;
import br.com.triadworks.javaweb.modelo.Caloteiro;

@WebServlet("/consultaCaloteiro")
public class ConsultaCaloteiro extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		Caloteiro caloteiro = new Caloteiro();

		caloteiro.setNome(nome);
		
		CaloteiroDAO dao = new CaloteiroDAO();
		// need dao.getCaloteiroByName
		
		RequestDispatcher rd = request.getRequestDispatcher("/resultadoBusca.jsp");
		rd.forward(request, response);

	}

}
