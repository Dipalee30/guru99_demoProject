package org.iit.guru99test;

import org.guru99helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day6Test extends TestBase {

	
	@Test(priority = 0)
	public void clickOnMyaccount() {
		/* Launch Application */
		launchApplication(" http://live.demoguru99.com/index.php/");
		/* Click on my account link */
		driver.findElement(By.xpath("//a[@href='http://live.demoguru99.com/index.php/customer/account/']")).click();
		driver.findElement(By.xpath("(//a[@title='My Account'])[1]")).click();
	}
	
	/* Log in into Application */
	@Test(priority = 1)
	public void logInIntoApplication()
	{
		driver.findElement(By.id("email")).sendKeys("rajdhaval@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("pwd1234");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		
	}
	
	/*Add TV TO WISHLIST*/
	@Test(priority = 2)
	 public void addTvToWishlist()
	 {
		 driver.findElement(By.xpath("//a[@href='http://live.demoguru99.com/index.php/tv.html']")).click();
			driver.findElement(By.xpath("(//a[@class='link-wishlist'])[1]")).click();
	 }
	
	/* Click on My Wishlist */
	@Test(priority = 3)
	public void clickOnMyWishlist()
	{
		driver.findElement(By.xpath("(//a[@href='http://live.demoguru99.com/index.php/wishlist/'])[2]")).click();
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		
	}
	/* Enter Shipping information */
	@Test(priority = 4)
	public void enterShippingInformation()
	{
		Select countrydrop=new Select(driver.findElement(By.id("country")));
		countrydrop.selectByVisibleText("United States");
		Select regiondrop=new Select(driver.findElement(By.id("region_id")));
		regiondrop.selectByVisibleText("New York");
		
		driver.findElement(By.id("postcode")).sendKeys("542896");
		
		driver.findElement(By.xpath("//button[@title='Estimate']")).click();
		
	}
	
	/* verify shipping cost generated */
	
	@Test(priority = 5)
	public void verifyShippingCostGenerated()
	{
		 String Actualshippingcost= driver.findElement(By.xpath("//li/input[@name='estimate_method']/following::label/span")).getText();
		
		 String Expectedshippingcost=" $5";
		 
		 try {
		 
		 Assert.assertEquals(Actualshippingcost, Expectedshippingcost);
		 
		   System.out.println("Acual Shipping cost matches with the Expected one");
		 }
		 catch (Exception e)
		 {
			e.printStackTrace(); 
		 }
	}
	
	/* Select Shipping cost and Update total */
	
	@Test(priority = 6)
	public void selectShippingAndUpdate()
	{
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		driver.findElement(By.xpath("//button[@title='Update Total']")).click();
	}
	
	/* verify Shipping cost is added to total cost */
	@Test(priority = 6)
	public void verifyShippingCostAddedToalCost()
	{
		String ActualTotalCost=driver.findElement(By.xpath("//td[@class='a-right']/strong/span")).getText();
		String Subtotal= driver.findElement(By.xpath("(//span[@class='cart-price']/span)[2]")).getText();
		 String Actualshippingcost= driver.findElement(By.xpath("//li/input[@name='estimate_method']/following::label/span")).getText();
		 
		 String ExpectedTotalCost=(Subtotal+Actualshippingcost);
		 
		 try {
			 
			 Assert.assertEquals(ActualTotalCost, ExpectedTotalCost);
			 
			   System.out.println(" Shipping cost is Added to total Product cost");
			 }
			 catch (Exception e)
			 {
				e.printStackTrace(); 
			 }
				 
	}
	
	/* Click Proceed to checkout and enter billing information */
	@Test(priority = 7)
	public void proceedToCheckout()
	{
		driver.findElement(By.xpath("(//button[@title='Proceed to Checkout'])[2]")).click();
		driver.findElement(By.id("billing:street1")).sendKeys("ABC");
		driver.findElement(By.id("billing:city")).sendKeys("ABC");
		
		Select region=new Select(driver.findElement(By.id("billing:region_id")));
		region.selectByVisibleText("New york");
		
		driver.findElement(By.id("billing:postcode")).sendKeys("542896");
		
		Select state=new Select(driver.findElement(By.id("billing:region_id")));
		state.selectByVisibleText("United States");
		
		driver.findElement(By.id("billing:telephone")).sendKeys("12345678");
		 
	}
	
}
