package br.com.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.triadworks.javaweb.dao.CaloteiroDAO;
import br.com.triadworks.javaweb.modelo.Caloteiro;

@WebServlet("/sistema")
public class ServletSistema extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("logica");
		
		if(acao.equals("AdicionaCaloteiro")) {
			
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
			
			caloteiro.setNome(nome);
			caloteiro.setEmail(email);
			caloteiro.setDevendo(new Integer(devendo));
			caloteiro.setDataDivida(dataDividaConvertida);
			
			
			CaloteiroDAO dao = new CaloteiroDAO();
			dao.adiciona(caloteiro);
			
			RequestDispatcher rd = request.getRequestDispatcher("/caloteiroAdicionado.jsp");
			rd.forward(request, response);
		} else if (acao.equals("ListaCaloteiro")) {
			
		} else if (acao.equals("AlteraCaloteiro")) {
			
		} else if (acao.equals("ListaCaloteiro")) {
			
		} else if (acao.equals("Deleta")) {
			
		}
		
		
	}

}
