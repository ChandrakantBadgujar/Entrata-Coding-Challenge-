package com.qa.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 {
  @Test
  public void test3() throws InterruptedException {
	  	EdgeOptions option= new EdgeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver= new EdgeDriver(option);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.entrata.com");
		
		WebElement cooki= driver.findElement(By.xpath("//button[@id='rcc-confirm-button']"));
		cooki.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
       
        WebElement carrerele = driver.findElement(By.xpath("///a[normalize-space()='Theme Gallery']")) ;
        carrerele.click();
        
        String expectedTitle="Theme Gallery | Entrata";
        String actualTitle= driver.getTitle();
	  	  
  	  	Assert.assertEquals(actualTitle, expectedTitle);
  	  	driver.close();
  }
}
