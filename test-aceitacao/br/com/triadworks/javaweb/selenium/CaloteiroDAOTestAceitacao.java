package br.com.triadworks.javaweb.selenium;

import static org.junit.Assert.assertEquals;

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

public class CaloteiroDAOTestAceitacao {
	
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
		
//		Savepoint savepoint1 = connection.setSavepoint();
//		
//		try {
//			connection.setAutoCommit(false);
//			
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
		WebDriver driver = new FirefoxDriver();
		CaloteiroDAO dao = new CaloteiroDAO();
		Integer tamanhoInicialDaLista = dao.getLista().size();
		System.out.println("Tamanho inicial da lista: " + tamanhoInicialDaLista);
		
		driver.get("http://localhost:8080/calote-web/adicionaCaloteiro.jsp");
		
		WebElement campoDeTextoDoNome = driver.findElement(By.name("nome"));
		campoDeTextoDoNome.sendKeys("Marcos Fernando Justino");

		WebElement campoDeTextoDoEmail = driver.findElement(By.name("email"));
		campoDeTextoDoEmail.sendKeys("davi.leitao@hotmail.com");
		
		WebElement campoDeTextoDaDivida = driver.findElement(By.name("devendo"));
		campoDeTextoDaDivida.sendKeys("800");
		
		WebElement campoDeTextoDaData = driver.findElement(By.name("dataDivida"));
		campoDeTextoDaData.sendKeys("28/12/2016");
		
		campoDeTextoDoNome.submit();
//		
//		try {
//			connection.commit();
//			connection.rollback(savepoint1);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		WebElement menuListaCaloteiros = driver.findElement(By.id("lista-caloteiro-menu"));
		menuListaCaloteiros.click();
		
		Integer tamanhoFinalDaLista = dao.getLista().size();
		List<Caloteiro> lista = dao.getLista();
		
		assertEquals(lista.get(tamanhoFinalDaLista - 1).getNome(), "Marcos Fernando Justino");
		assertEquals(Double.valueOf(tamanhoInicialDaLista + 1), new Double(tamanhoFinalDaLista));
		
		driver.close();
		driver.quit();
		
	}
}
