package main.java.triadworks.javaweb.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName="FiltroTempo", urlPatterns="/*")
public class FiltroTempo implements Filter {

	@Override
	public void destroy() {
		Filter.super.destroy();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		long tempoInicial = System.currentTimeMillis();
		
		arg2.doFilter(arg0, arg1);
		
		long tempoFinal = System.currentTimeMillis();
		
		String uri = ((HttpServletRequest)arg0).getRequestURI();
		System.out.println("Requisição para: " + uri + " levou : " + (tempoFinal - tempoInicial));
		
	}

}
