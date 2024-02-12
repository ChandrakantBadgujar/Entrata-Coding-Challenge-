package com.qa.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase4 {
  @Test
  public void test4() {
	  	EdgeOptions option= new EdgeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver= new EdgeDriver(option);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.entrata.com");
		
		WebElement cooki= driver.findElement(By.xpath("//button[@id='rcc-confirm-button']"));
		cooki.click();
		
		WebElement solution = driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[1]/div/div/div[2]/div[2]/div[1]"));
		
		Actions objaction= new Actions(driver);
		
		objaction.moveToElement(solution).build().perform();
		
		WebElement student = driver.findElement(By.xpath("//div[@class='header-drop-nav']//a[@class='fat-nav-links'][normalize-space()='Student']"));
		student.click();
		
		String expectedTitle="Property Management Software | Entrata";
        String actualTitle= driver.getTitle();
	  	  
  	  	Assert.assertEquals(actualTitle, expectedTitle);
  	  	driver.close();
  }
  
}
