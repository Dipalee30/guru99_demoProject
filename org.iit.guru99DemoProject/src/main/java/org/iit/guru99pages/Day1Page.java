package org.iit.guru99pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Day1Page {

	
	
	private final WebDriver driver;
	
	public Day1Page (WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickOnMobile()
	{
		driver.findElement(By.linkText("Mobile")).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
