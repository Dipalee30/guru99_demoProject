package org.iit.guru99test;

import org.guru99helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Day5Test extends TestBase {

	/* Click on my account link */
	@Test(priority = 0)
	public void clickOnMyaccount() {
		/* Launch Application */
		launchApplication(" http://live.demoguru99.com/index.php/");
		/* Click on my account link */
		driver.findElement(By.xpath("//a[@href='http://live.demoguru99.com/index.php/customer/account/']")).click();
		driver.findElement(By.xpath("(//a[@title='My Account'])[1]")).click();

	}

	/* Registration */
	@Test(priority = 1)
	public void registration() {
		/* click on create my account link */
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		/* Fill all the details */
		driver.findElement(By.id("firstname")).sendKeys("ghi");
		driver.findElement(By.id("middlename")).sendKeys("m");
		driver.findElement(By.id("lastname")).sendKeys("ert");
		driver.findElement(By.id("email_address")).sendKeys("ghiert@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Pwd1234");
		driver.findElement(By.id("confirmation")).sendKeys("Pwd1234");
		driver.findElement(By.xpath("//button[@title='Register']")).click();

	}

	/* Verify Registration is done */
	@Test(priority = 2)
	public void verifyRegistrationDone() {

		String ActualMessage = driver.findElement(By.xpath("//li[@class='success-msg']/ul/li/span")).getText();
		System.out.println("Actual Registration message is" + ActualMessage);
		String ExpectedMessage = "Account Registration is done";
		System.out.println("Expected Registration message is" + ExpectedMessage);

		if (ActualMessage.equals(ExpectedMessage)) {
			System.out.println("Actual registration message matches with the Expected ");
		} else {
			System.out.println("Actual registration message does not matches with the Expected ");
		}

	}

	/* go to TV menu */
	@Test(priority = 3)
	public void goToTv() {
		driver.findElement(By.xpath("//a[@href='http://live.demoguru99.com/index.php/tv.html']")).click();
		driver.findElement(By.xpath("(//a[@class='link-wishlist'])[1]")).click();

		driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();

		driver.findElement(By.id("email_address")).sendKeys("rajdhaval@gmail.com");

		driver.findElement(By.id("message")).sendKeys("This is my Wishlist");
		driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();

	}

	/* Check wishlist is shared */

	@Test(priority = 4)
	public void checkWishList() {
		String ActualWishListMess = driver.findElement(By.xpath("//li[@class='success-msg']/ul/li/span")).getText();
		System.out.println("Actual Wishlist success message is" + ActualWishListMess);
		String ExpectedWishListMess = "Wishlist Shared Successfully";
		System.out.println("Expected Wishlist success message is" + ExpectedWishListMess);

		if (ActualWishListMess.equals(ExpectedWishListMess)) {
			System.out.println("Actual Wishlist success message matches with the Expected ");
		} else {
			System.out.println("Actual Wishlist success message does not matches with the Expected ");
		}

	}

}
