package br.com.triadworks.javaweb.selenium;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.triadworks.javaweb.dao.CaloteiroDAO;
import br.com.triadworks.javaweb.dao.ConnectionFactory;
import br.com.triadworks.javaweb.modelo.Caloteiro;

public class CaloteiroDAOAceitacaoTest {
	
	private java.sql.Connection connection;
	
	@Before
	public void setUp() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	@After
	public void tearDown() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deveAdicionarUmCaloteiroAceitacao() throws SQLException {
		
		WebDriver driver = new FirefoxDriver();
		Connection conexao = new ConnectionFactory().getConnection();
		CaloteiroDAO dao = new CaloteiroDAO(conexao);
		
		Integer tamanhoInicialDaLista = dao.getLista().size();
		
		driver.get("http://localhost:8080/cobrancaEContabilidade/login.jsp");
		waitForSelenium(new Long(500));
		
		WebElement campoDoLogin = driver.findElement(By.name("login"));
		campoDoLogin.sendKeys("Handerson");
		waitForSelenium(new Long(100));
		
		WebElement campoDoSenha = driver.findElement(By.name("senha"));
		campoDoSenha.sendKeys("123");
		waitForSelenium(new Long(500));
		
		WebElement submitButton = driver.findElement(By.id("submit-btn"));
		submitButton.click();
		waitForSelenium(new Long(1000));
		
		WebElement adicionaLink = driver.findElement(By.id("adicionaLink"));
		adicionaLink.click();
		waitForSelenium(new Long(1000));
		
		WebElement campoDeTextoDoNome = driver.findElement(By.name("nome"));
		campoDeTextoDoNome.sendKeys("Novo-ze333");
		waitForSelenium(new Long(100));

		WebElement campoDeTextoDoEmail = driver.findElement(By.name("email"));
		campoDeTextoDoEmail.sendKeys("davi.leitao@hotmail.com");
		waitForSelenium(new Long(100));
		
		WebElement campoDeTextoDaDivida = driver.findElement(By.name("devendo"));
		campoDeTextoDaDivida.sendKeys("8000000");
		waitForSelenium(new Long(300));
		
		WebElement campoDeTextoDaData = driver.findElement(By.name("dataDivida"));
		campoDeTextoDaData.sendKeys("28/12/2016");
		waitForSelenium(new Long(100));
		
		WebElement btnSubmit = driver.findElement(By.id("btn-submit"));
		btnSubmit.click();
		waitForSelenium(new Long(1000));
		
		Integer tamanhoFinalDaLista = dao.getLista().size();
		
		List<Caloteiro> lista = dao.getLista();
		
		assertEquals(Double.valueOf(tamanhoInicialDaLista + 1), new Double(tamanhoFinalDaLista));
		assertEquals("Novo-ze333", lista.get(tamanhoFinalDaLista - 1).getNome());
		waitForSelenium(new Long(1000));
		driver.close();
		driver.quit();
	}
	

	private void waitForSelenium(Long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
