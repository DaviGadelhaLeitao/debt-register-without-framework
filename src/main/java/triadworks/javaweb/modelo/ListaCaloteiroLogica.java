package main.java.triadworks.javaweb.modelo;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import main.java.triadworks.javaweb.dao.CaloteiroDAO;

public class ListaCaloteiroLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		CaloteiroDAO dao = new CaloteiroDAO((Connection)request.getAttribute("conexao"));

		RequestDispatcher rd = request.getRequestDispatcher("/listaCaloteiro.jsp");
		request.setAttribute("lista", dao.getLista());
		rd.forward(request, response);
		
	}
}