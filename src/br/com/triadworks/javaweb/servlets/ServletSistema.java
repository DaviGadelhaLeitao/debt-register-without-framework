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
import br.com.triadworks.javaweb.modelo.AdicionaCaloteiroLogica;
import br.com.triadworks.javaweb.modelo.Caloteiro;
import br.com.triadworks.javaweb.modelo.Logica;

@WebServlet("/sistema")
public class ServletSistema extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("logica");
		String nomeClasse = "br.com.triadworks.javaweb.modelo."+acao+"Logica";
		
		try {
			Class classe = Class.forName(nomeClasse);
			Object obj = classe.newInstance();
			Logica logica = (Logica) obj;
			logica.executa(request, response);
		} catch (ClassNotFoundException e) {
			throw new CaloteiroServletException(e.getMessage());
		} catch (InstantiationException | IllegalAccessException e) {
			throw new CaloteiroServletException(e.getMessage());
		} catch (Exception e) {
			throw new CaloteiroServletException(e.getMessage());
		}
	}

}
