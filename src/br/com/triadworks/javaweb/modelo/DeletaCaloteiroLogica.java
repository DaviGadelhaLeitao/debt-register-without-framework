package br.com.triadworks.javaweb.modelo;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.triadworks.javaweb.dao.CaloteiroDAO;

public class DeletaCaloteiroLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long id = new Long(request.getParameter("id"));
		CaloteiroDAO dao = new CaloteiroDAO((Connection)request.getAttribute("conexao"));
		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setId(id);
		dao.deleta(caloteiro);
		
		request.setAttribute("lista", dao.getLista());
		RequestDispatcher rd = request.getRequestDispatcher("/listaCaloteiro.jsp");
		rd.forward(request, response);
	}
}
