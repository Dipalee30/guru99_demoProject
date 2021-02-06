package org.iit.guru99test;

import org.guru99helper.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Day3Test extends TestBase {

	/* Click on Mobile */
	@Test(priority = 0)
	public void clickOnMobile() {

		/* Launch Application */
		launchApplication(" http://live.demoguru99.com/index.php/");

		driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();

	}

	/* click on Add to cart */
	@Test(priority = 1)
	public void addToCart() {

		driver.findElement(By.xpath("(//button[@class='button btn-cart'])[1]")).click();

		driver.findElement(By.xpath("(//input[@type='text'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("1000");

		driver.findElement(By.xpath("//button[@class='button btn-update']")).click();
	}

	/* Verify error message */
	@Test(priority = 2)
	public void verifyErrorMessage() {

		String message1 = driver.findElement(By.xpath("//li[@class='error-msg']/child::ul/li/span")).getText();

		String message2 = "The requested quantity for Sony Experia is not available";

		System.out.println("Actual error message is" + message1);
		System.out.println("Expected error message is" + message2);

		if (message1.equals(message2)) {
			System.out.println("Actual error message is matches with the expected error message");

		} else {
			System.out.println("Actual error message is not matches with the expected error message");
		}
	}

	/* Click on the Empty Cart link */
	@Test(priority = 3)
	public void clickOnEmptyCart() throws InterruptedException {

		driver.findElement(By.xpath("//button[@title='Empty Cart']/child::span/span")).click();
		Thread.sleep(2000);

	}

	/* Verify shopping cart is empty */
	@Test(priority = 4)
	public void verifyEmptyShoppingCart() {
		String Actual = driver.findElement(By.xpath("//div[@class='main']/child::div/div/h1")).getText();
		String Expected = "SHOPPING CART IS EMPTY";

		System.out.println("Actual message is" + Actual);
		System.out.println("Expected message is" + Expected);
		if (Actual.equals(Expected)) {
			System.out.println("Actual message is matches with the expected message");

		} else {
			System.out.println("Actual message is not matches with the expected message");
		}
	}

}
