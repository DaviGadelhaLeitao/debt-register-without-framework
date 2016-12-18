package br.com.triadworks.javaweb.dao.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import br.com.triadworks.javaweb.dao.ConnectionFactory;
import br.com.triadworks.javaweb.modelo.Caloteiro;

public class CaloteiroDAOTest {
	
	private Connection conexao;

	@Before
	public void criaConexao() {
		this.conexao = new ConnectionFactory().getConnection();
	}

	@Test
	public void deveAdicionarCaloteiroNoBanco() {
		
		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setNome("João");
		caloteiro.setEmail("joao@hotmail.com");
		caloteiro.setDevendo(300);
		
		String sql = "insert into caloteiro " + "(nome, email, devendo, dataDivida)" + "values (?,?,?,?)";

		try {
			PreparedStatement pstmt = conexao.prepareStatement(sql);

			pstmt.setString(1, caloteiro.getNome());
			pstmt.setString(2, caloteiro.getEmail());
			pstmt.setInt(3, caloteiro.getDevendo());

			pstmt.execute();
			pstmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
}
