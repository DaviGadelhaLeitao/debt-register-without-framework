package br.com.triadworks.javaweb.selenium;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaloteiroDAOTestAceitacao {
	
	@Test
	public void deveAdicionarUmCaloteiroAceitacao() {
		Thread thread = new Thread();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://localhost:8080/calote-web/adicionaCaloteiro.jsp");
		
		WebElement campoDeTextoDoNome = driver.findElement(By.name("nome"));
		campoDeTextoDoNome.sendKeys("Davi Gadelha Leitao");
		
		WebElement campoDeTextoDoEmail = driver.findElement(By.name("email"));
		campoDeTextoDoEmail.sendKeys("davi.leitao@hotmail.com");
		
		WebElement campoDeTextoDaDivida = driver.findElement(By.name("devendo"));
		campoDeTextoDaDivida.sendKeys("300");
		
		WebElement campoDeTextoDaData = driver.findElement(By.name("dataDivida"));
		campoDeTextoDaData.sendKeys("28/12/2016");
		
		wait(thread, new Long(2000));
		
		campoDeTextoDoNome.submit();
		
		wait(thread, new Long(2000));
		
		WebElement menuListaCaloteiros = driver.findElement(By.id("lista-caloteiro-menu"));
		menuListaCaloteiros.click();
		
	}

	private void wait(Thread thread, Long time) {
		try {
			thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
