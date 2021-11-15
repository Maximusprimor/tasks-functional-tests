package br.ce.wcaquino.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class TasksTest {
	
	public WebDriver acessarAplicacao() {
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}

	@Test
	public void deveSalvarTarefaComSucesso() {
		
		WebDriver driver = acessarAplicacao();
		try {
		
			//clicar em add todo
			driver.findElement(By.id("addTodo")).click();	
		
			//escrever a descricao
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
			//escrever a data
			driver.findElement(By.id("dueDate")).sendKeys("15/11/2021");
		
			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();
		
			//validar sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Success!", message);
		
		}
		finally {
				
			//fechar o browser
			driver.quit();
			
		}

	}
	
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
		
		WebDriver driver = acessarAplicacao();
		try {
		
			//clicar em add todo
			driver.findElement(By.id("addTodo")).click();	
		
			//escrever a data
			driver.findElement(By.id("dueDate")).sendKeys("15/11/2021");
		
			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();
		
			//validar sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the task description", message);
		
		}
		finally {
				
			//fechar o browser
			driver.quit();
			
		}

	}
	

	@Test
	public void naoDeveSalvarTarefaSemData() {
		
		WebDriver driver = acessarAplicacao();
		try {
		
			//clicar em add todo
			driver.findElement(By.id("addTodo")).click();	
		
			//escrever a descricao
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();
		
			//validar sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the due date", message);
		
		}
		finally {
				
			//fechar o browser
			driver.quit();
			
		}

	}
	
	
	@Test
	public void naoDeveSalvarTarefaComDataPassada() {
		
		WebDriver driver = acessarAplicacao();
		try {
		
			//clicar em add todo
			driver.findElement(By.id("addTodo")).click();	
		
			//escrever a descricao
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
			//escrever a data
			driver.findElement(By.id("dueDate")).sendKeys("15/11/2011");
		
			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();
		
			//validar sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Due date must not be in past", message);
		
		}
		finally {
				
			//fechar o browser
			driver.quit();
			
		}

	}
	
}
