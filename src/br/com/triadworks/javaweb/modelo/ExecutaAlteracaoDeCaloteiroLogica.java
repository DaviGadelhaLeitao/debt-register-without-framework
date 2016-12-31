package br.com.triadworks.javaweb.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.triadworks.javaweb.dao.CaloteiroDAO;

public class ExecutaAlteracaoDeCaloteiroLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long id = new Long(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String devendo = request.getParameter("devendo");
		
		String dataDivida = request.getParameter("dataDivida");
		Calendar dataDividaConvertida = null;
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataDivida);
			dataDividaConvertida = Calendar.getInstance();
			dataDividaConvertida.setTime(data);
		} catch (ParseException e) {
			throw new RuntimeException();
		}
		
		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setId(id);
		caloteiro.setNome(nome);
		caloteiro.setEmail(email);
		caloteiro.setDevendo(new Integer(devendo));
		caloteiro.setDataDivida(dataDividaConvertida);
		
		CaloteiroDAO dao = new CaloteiroDAO();
		dao.altera(caloteiro);
		
		request.setAttribute("lista", dao.getLista());
		RequestDispatcher rd = request.getRequestDispatcher("/listaCaloteiro.jsp");
		rd.forward(request, response);
	}
}
