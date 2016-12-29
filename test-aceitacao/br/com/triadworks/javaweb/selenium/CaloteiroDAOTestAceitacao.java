package br.com.triadworks.javaweb.selenium;

import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


import br.com.triadworks.javaweb.dao.ConnectionFactory;

public class CaloteiroDAOTestAceitacao {
	
	private java.sql.Connection connection;
	private static Long tempoDeEspera = new Long(300);
	
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
		
		Savepoint savepoint1 = connection.setSavepoint();
		try {
			connection.setAutoCommit(false);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Thread thread = new Thread();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://localhost:8080/calote-web/adicionaCaloteiro.jsp");
		
		WebElement campoDeTextoDoNome = driver.findElement(By.name("nome"));
		campoDeTextoDoNome.sendKeys("Marcos Fernando Justino");
		
		WebElement campoDeTextoDoEmail = driver.findElement(By.name("email"));
		campoDeTextoDoEmail.sendKeys("davi.leitao@hotmail.com");
		
		WebElement campoDeTextoDaDivida = driver.findElement(By.name("devendo"));
		campoDeTextoDaDivida.sendKeys("800");
		
		WebElement campoDeTextoDaData = driver.findElement(By.name("dataDivida"));
		campoDeTextoDaData.sendKeys("28/12/2016");
		
		wait(thread, new Long(tempoDeEspera));
		
		campoDeTextoDoNome.submit();
		try {
			connection.commit();
			connection.rollback(savepoint1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		wait(thread, new Long(tempoDeEspera));
		
		WebElement menuListaCaloteiros = driver.findElement(By.id("lista-caloteiro-menu"));
		menuListaCaloteiros.click();
		
	}
	
	private void wait(Thread thread, Long time) {
		try {
			thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
