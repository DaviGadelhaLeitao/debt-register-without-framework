package br.com.triadworks.javaweb.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.google.com.br/");
		WebElement textField = driver.findElement(By.name("q"));
		textField.sendKeys("Carinne Justino");
		textField.submit();
		
		driver.close();
	}
}
