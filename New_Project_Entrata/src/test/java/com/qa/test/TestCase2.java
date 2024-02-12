package com.qa.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCase2 {
  @Test
  public void Test2() {
	  
	  EdgeOptions option= new EdgeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver= new EdgeDriver(option);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.entrata.com");
		
		WebElement cooki= driver.findElement(By.xpath("//button[@id='rcc-confirm-button']"));
		cooki.click();
		
		WebElement demobutton= driver.findElement(By.xpath("//a[@class='button-default solid-dark-button'][normalize-space()='Watch Demo']"));
		demobutton.click();
		
		WebElement fname= driver.findElement(By.xpath("//input[@id='FirstName']"));
		fname.sendKeys("Rahul");
		
		WebElement lname= driver.findElement(By.xpath("//input[@id='LastName']"));
		lname.sendKeys("Sharma");
		
		WebElement mail= driver.findElement(By.xpath("//input[@id='Email']"));
		mail.sendKeys("abc@gmail.com");
		
		WebElement cname= driver.findElement(By.xpath("//input[@id='Company']"));
		cname.sendKeys("xyz solution");
		
		WebElement pnumber= driver.findElement(By.xpath("//input[@id='Phone']"));
		pnumber.sendKeys("xyz solution");
		
		WebElement ucount= driver.findElement(By.xpath("//select[@id='Unit_Count__c']"));
		Select drop= new Select(ucount);
		drop.selectByIndex(1);
		
		WebElement jobtitle= driver.findElement(By.xpath("//input[@id='Title']"));
		jobtitle.sendKeys("manager");
  }
}
