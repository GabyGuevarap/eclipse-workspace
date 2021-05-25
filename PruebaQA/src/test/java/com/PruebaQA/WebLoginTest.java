package com.PruebaQA;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

public class WebLoginTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cc.healthrecoverysolutions.com/login");
		//driver.get("https://www.google.com"); -comentado
	}
	
	@Test
	public void testWebLogin() throws InterruptedException {
		WebElement username = driver.findElement(By.name("username"));
		username.clear();
		username.sendKeys("Gaby");
		username.submit();
		
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("12345678");
		password.submit();
				
		WebElement submitbutton = driver.findElement(By.id("loginSubmitButton"));
		submitbutton.click();	
		

		//Scenario: Login con email y password vacio
		username.clear();
		username.sendKeys("Gaby@");
		username.submit();
		
		password.clear();
		password.submit();
				
		submitbutton.click();	

	
		//Scenario: Login con email vacio y password
		username.clear();
		password.clear();
		password.sendKeys("12345678");
			
		submitbutton.click();	
			
		
		//Scenario: Login con email vacio y password vacio
		username.clear();
		password.clear();
		submitbutton.click();	

		//Scenario:Probando Boton de Ver Password
		WebElement eyebuttom = driver.findElement(By.cssSelector("#loginPage > div.login-block > div > div.single-page-block-inner.effect-3d-element > div.single-page-block-form.ng-scope > form > div:nth-child(5) > div > span"));
		eyebuttom.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Scenario:Probando abrir pagina de Clave Olvidada
		//WebElement linktextforgot = driver.findElement(By.linkText("Forgot Password?"));
		WebElement linktextforgot = driver.findElement(By.cssSelector("#loginPage > div.login-block > div > div.single-page-block-inner.effect-3d-element > div.single-page-block-form.ng-scope > form > div:nth-child(6) > a"));
		//WebElement linktextforgot = driver.findElement(By.xpath("//div[@id='loginPage']/div[2]/div/div/div[2]/form/div[4]/a"));
		linktextforgot.click();

		String actualUrl="https://cc.healthrecoverysolutions.com/login"; 
		String expectedUrl= driver.getCurrentUrl(); 
		org.junit.Assert.assertEquals(expectedUrl,actualUrl);				
		
		Thread.sleep(2000);
		
	}	
	@After
	public void tearDown() {
		driver.quit();
	}
}
