package br.com.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.triadworks.javaweb.dao.CaloteiroDAO;
import br.com.triadworks.javaweb.modelo.Caloteiro;

 
/* pega os dados da requisição e seta num objeto caloteiro. Depois salva no banco usando
 *  o DAO e exibe um HTML com o resultado * 
 */
@WebServlet("/adicionaCaloteiro")
public class AdicionaCaloteiro extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*********************************************
		 *** PARTE 1 - PEGA OS DADOS DA REQUISIÇÃO ***
		 *********************************************/
		
		// elemento que vai fazer utilizado para exibir uma saída HTML
		PrintWriter out = response.getWriter();
		
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
			out.println("Erro de conversão de data.");
		}
		
		
		/*********************************************
		 *** PARTE 2 - MONTA UM OBJETO CALOTEIRO   ***
		 *********************************************/
		
		Caloteiro caloteiro = new Caloteiro();
		
		caloteiro.setNome(nome);
		caloteiro.setEmail(email);
		caloteiro.setDevendo(new Integer(devendo));
		caloteiro.setDataDivida(dataDividaConvertida);
		
		
		/*********************************************
		 *** PARTE 3 - SALVA NO BANCO e EXIBE UM HTML*
		 *********************************************/
		
		CaloteiroDAO dao = new CaloteiroDAO();
		dao.adiciona(caloteiro);
		
		out.println("<html>");
		out.println("<body>");
		out.println("Caloteiro " + caloteiro.getNome() + " adicionado com sucesso.");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
}
































































