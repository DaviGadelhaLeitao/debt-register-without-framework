package br.com.triadworks.javaweb.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.Test;

import br.com.triadworks.javaweb.dao.ConnectionFactory;
import br.com.triadworks.javaweb.dao.UsuarioDAO;
import br.com.triadworks.javaweb.modelo.Usuario;

public class UsuarioDAOTest {

	@Test
	public void deveRetornarUmUsuarioDoBanco() {

		Connection conexao = new ConnectionFactory().getConnection();

		UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

		Usuario usuarioLogado = usuarioDAO.autentica("Handerson", "123");

		assertEquals(true, (usuarioLogado != null));
	}

	@Test(expected=AssertionError.class)
	public void naoDeveEncontrarUmUsuarioNoBanco() {

		Connection conexao = new ConnectionFactory().getConnection();

		UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

		Usuario usuarioLogado = usuarioDAO.autentica("ChicoUyzher", "123");
		
		assertTrue(usuarioLogado != null);
	}

}
