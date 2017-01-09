package br.com.triadworks.javaweb.dao.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.triadworks.javaweb.dao.CaloteiroDAO;
import br.com.triadworks.javaweb.dao.ConnectionFactory;
import br.com.triadworks.javaweb.modelo.Caloteiro;

public class CaloteiroDAOTest {

	private Connection conexao;

	@Before
	public void setUp() {
		this.conexao = new ConnectionFactory().getConnection();
		limpaTabelaCaloteiro();
	}

	@After
	public void tearDown() {
		try {
			limpaTabelaCaloteiro();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void limpaTabelaCaloteiro() {
		String sql = "delete from caloteiro";

		try {
			PreparedStatement pstmt = conexao.prepareStatement(sql);

			pstmt.execute();
			pstmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Caloteiro getCaloteiroTeste(String nome) {
		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setNome(nome);
		caloteiro.setEmail("joao@hotmail.com");
		caloteiro.setDataDivida(Calendar.getInstance());
		caloteiro.setDevendo(300);
		return caloteiro;
	}
	
	@Test
	public void deveLimparATabelaDoBancoDeDados() {
		Connection conexao = new ConnectionFactory().getConnection();
		CaloteiroDAO dao = new CaloteiroDAO(conexao);
		
		limpaTabelaCaloteiro();
		
		List<Caloteiro> lista = dao.getLista();
		
		assertEquals(0, lista.size());
	}

	@Test
	public void deveAdicionarCaloteiroNoBanco() {

		Caloteiro caloteiro = getCaloteiroTeste("Joao");

		Connection conexao = new ConnectionFactory().getConnection();
		CaloteiroDAO dao = new CaloteiroDAO(conexao);
		dao.adiciona(caloteiro);

		List<Caloteiro> lista = dao.getLista();
		
		assertEquals(1, lista.size());
		assertEquals("Joao", lista.get(0).getNome());
	}
	
	@Test
	public void deveDeletarCaloteiroNoBanco() {

		Caloteiro caloteiro = getCaloteiroTeste("Joao");

		Connection conexao = new ConnectionFactory().getConnection();
		CaloteiroDAO dao = new CaloteiroDAO(conexao);
		dao.adiciona(caloteiro);

		caloteiro.setId(dao.getLista().get(0).getId());
		dao.deleta(caloteiro);

		List<Caloteiro> lista = dao.getLista();
		assertEquals(0, lista.size());
	}

	@Test
	public void deveRetornarUmCaloteiro() {
		Caloteiro caloteiro = getCaloteiroTeste("Joao");

		Connection conexao = new ConnectionFactory().getConnection();
		CaloteiroDAO dao = new CaloteiroDAO(conexao);
		dao.adiciona(caloteiro);
		caloteiro.setId(dao.getLista().get(0).getId());
		Long id = caloteiro.getId();
		Caloteiro caloteiroDoBanco = dao.getCaloteiro(id);

		assertEquals(dao.getLista().get(0).getId(), caloteiroDoBanco.getId());
	}

	@Test
	public void deveAlterarUmCaloteiro() {

		Caloteiro caloteiro = getCaloteiroTeste("Joao");

		Connection conexao = new ConnectionFactory().getConnection();
		CaloteiroDAO dao = new CaloteiroDAO(conexao);
		dao.adiciona(caloteiro);
		String oldName = caloteiro.getNome();
		Integer oldDevendo = caloteiro.getDevendo();
		String oldEmail = caloteiro.getEmail();
		Long oldId = dao.getLista().get(0).getId();
		caloteiro.setNome("newName");
		caloteiro.setEmail("newEmail");
		caloteiro.setDevendo(oldDevendo - 10);
		caloteiro.setDataDivida(Calendar.getInstance());
		caloteiro.setId(oldId);
		
		dao.altera(caloteiro);

		assertNotEquals(oldName, caloteiro.getNome());
		assertNotEquals(oldEmail, caloteiro.getEmail());
		assertNotEquals(oldDevendo, caloteiro.getDevendo());
		assertEquals(oldId, caloteiro.getId());
	}

}
