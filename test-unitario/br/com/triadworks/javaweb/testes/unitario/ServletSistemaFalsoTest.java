package br.com.triadworks.javaweb.testes.unitario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.triadworks.javaweb.servlets.CaloteiroServletException;
import br.com.triadworks.javaweb.servlets.ServletSistema;

public class ServletSistemaFalsoTest extends Mockito {

	@Test(expected=CaloteiroServletException.class)
	public void deveCausarUmaClassNotFoundException() throws ServletException, IOException {
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		when(request.getParameter("logica")).thenReturn("NaoExiste");
		
		new ServletSistema().service(request, response);
	}
	
	@Test
	public void deveExecutarUmaLogicaListaCaloteiro() throws ServletException, IOException {
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		when(request.getParameter("logica")).thenReturn("ListaCaloteiro");
		
		new ServletSistema().service(request, response);
	}
	
	@Test
	public void deveExecutarLogicaAdicionaCaloteiro() throws ServletException, IOException {
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getParameter("logica")).thenReturn("AdicionaCaloteiro");
		when(request.getParameter("nome")).thenReturn("Joao");
		when(request.getParameter("email")).thenReturn("email@google.com");
		when(request.getParameter("devendo")).thenReturn("300");
		when(request.getParameter("dataDivida")).thenReturn("20/12/2016");
		
		new ServletSistema().service(request, response);
	}
}
