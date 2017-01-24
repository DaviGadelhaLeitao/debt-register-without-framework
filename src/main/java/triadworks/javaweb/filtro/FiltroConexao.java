package main.java.triadworks.javaweb.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import main.java.triadworks.javaweb.dao.ConnectionFactory;
import main.java.triadworks.javaweb.servlets.CaloteiroServletException;

@WebFilter(filterName="FiltroConexao", urlPatterns="/sistema")
public class FiltroConexao implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Connection conexao = new ConnectionFactory().getConnection();
		request.setAttribute("conexao", conexao);
		chain.doFilter(request, response);
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CaloteiroServletException("Erro ao tentar fechar conexão com o banco.");
		}
	}
	
	@Override
	public void destroy() {
		Filter.super.destroy();
	}

}
