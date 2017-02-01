package br.com.triadworks.javaweb.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.triadworks.javaweb.modelo.Usuario;

@WebFilter(filterName="FiltroAutorizacao", urlPatterns="/*")
public class FiltroAutorizacao implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String logica = req.getParameter("logica");
		if(logica == null) {
			logica = "";
		}
		if(uri.equals("login.jsp") || logica.endsWith("AutenticaUsuario") || uri.endsWith("png")|| uri.endsWith("jpg") || uri.endsWith("css")) {
			chain.doFilter(request, response);
		} else {
			Usuario usuarioLogado = (Usuario) req.getSession().getAttribute("usuarioLogado");
			if(usuarioLogado != null) {
				chain.doFilter(request, response);
				
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				request.setAttribute("msgUsuario", "Usuário não logado!");
				rd.forward(request, response);
			}
			
		}
		
		
	}
	

}
