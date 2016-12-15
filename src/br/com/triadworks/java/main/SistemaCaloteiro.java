package br.com.triadworks.java.main;


import java.sql.Connection;

import br.com.triadworks.javaweb.dao.CaloteiroDAO;
import br.com.triadworks.javaweb.dao.ConnectionFactory;
import br.com.triadworks.javaweb.modelo.Caloteiro;

public class SistemaCaloteiro {

	public static void main(String[] args) {
		Caloteiro caloteiro = new Caloteiro();
		
		caloteiro.setNome("davi");
		caloteiro.setEmail("email");
		caloteiro.setDevendo(300);
		caloteiro.getDataDivida();
		
		CaloteiroDAO dao = new CaloteiroDAO();
		dao.adiciona(caloteiro);
		System.out.println("gravado!");
		
		
	}

}
