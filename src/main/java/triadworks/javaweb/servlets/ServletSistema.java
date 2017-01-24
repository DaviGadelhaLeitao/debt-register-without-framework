package main.java.triadworks.javaweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.triadworks.javaweb.modelo.Logica;

@WebServlet("/sistema")
public class ServletSistema extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("logica");
		String nomeClasse = "main.java.triadworks.javaweb.modelo."+acao+"Logica";
		
		try {
			Class classe = Class.forName(nomeClasse);
			Object obj = classe.newInstance();
			Logica logica = (Logica) obj;
			logica.executa(request, response);
		} catch (ClassNotFoundException e) {
			throw new CaloteiroServletException(e.getMessage());
		} catch (InstantiationException | IllegalAccessException e) {
			throw new CaloteiroServletException(e.getMessage());
		} catch (NullPointerException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("Caught: " + e);
			throw new CaloteiroServletException(e.getCause());
		}
	}
}
