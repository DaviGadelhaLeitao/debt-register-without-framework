package br.com.triadworks.javaweb.modelo;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.triadworks.javaweb.dao.CaloteiroDAO;

public class DeletaCaloteiroLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long id = new Long(request.getParameter("id"));
		CaloteiroDAO dao = new CaloteiroDAO();
		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setId(id);
		dao.deleta(caloteiro);
		
		RequestDispatcher rd = request.getRequestDispatcher("/caloteiroDeletado.jsp");
		rd.forward(request, response);
	}
}
