package com.qa.test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase1 {
  @Test
  public void test_Case_1() throws InterruptedException {
	  	EdgeOptions option= new EdgeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver= new EdgeDriver(option);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.entrata.com");
		
		WebElement cooki= driver.findElement(By.xpath("//button[@id='rcc-confirm-button']"));
		cooki.click();
		WebElement siginbutton= driver.findElement(By.xpath("//a[@class='button-default outline-dark-button']"));
		siginbutton.click();
		
		WebElement propButton= driver.findElement(By.xpath("//a[@title='Client Login Button']"));
		propButton.click();
		
		WebElement username= driver.findElement(By.xpath("//input[@id='entrata-username']"));
		username.sendKeys("admin");
		
		WebElement pass= driver.findElement(By.xpath("//input[@id='entrata-password']"));
		pass.sendKeys("admin");
		
		WebElement signclick= driver.findElement(By.xpath("//button[@type='submit']"));
		signclick.click();
		
		WebElement text= driver.findElement(By.xpath("//p[@id='statusMessage']"));
		String actualtext= text.getText();
		String expectedText = "The username and password provided are not valid. Please try again.";
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualtext, expectedText, "The username and password provided are not valid. Please try again.");
		
		Thread.sleep(5000);
		driver.close();
  }
}
