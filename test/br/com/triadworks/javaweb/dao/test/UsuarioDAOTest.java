package br.com.triadworks.javaweb.dao.test;

import java.sql.Connection;

import org.junit.Test;

import br.com.triadworks.javaweb.dao.ConnectionFactory;
import br.com.triadworks.javaweb.dao.UsuarioDAO;
import br.com.triadworks.javaweb.modelo.Usuario;
import junit.framework.AssertionFailedError;

import static junit.framework.Assert.*;

public class UsuarioDAOTest {

	@SuppressWarnings("deprecation")
	@Test
	public void deveRetornarUmUsuarioDoBanco() {

		Connection conexao = new ConnectionFactory().getConnection();

		UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

		Usuario usuarioLogado = usuarioDAO.autentica("Handerson", "123");

		assertEquals(true, (usuarioLogado != null));
	}

	@Test(expected=AssertionFailedError.class)
	public void naoDeveEncontrarUmUsuarioNoBanco() {

		Connection conexao = new ConnectionFactory().getConnection();

		UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

		Usuario usuarioLogado = usuarioDAO.autentica("ChicoUyzher", "123");
		
		assertEquals(true, (usuarioLogado != null));

	}

}
