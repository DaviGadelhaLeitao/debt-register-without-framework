package test.java.triadworks.javaweb.integracao;

import static junit.framework.Assert.assertEquals;

import java.sql.Connection;

import org.junit.Test;

import junit.framework.AssertionFailedError;
import main.java.triadworks.javaweb.dao.ConnectionFactory;
import main.java.triadworks.javaweb.dao.UsuarioDAO;
import main.java.triadworks.javaweb.modelo.Usuario;

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
