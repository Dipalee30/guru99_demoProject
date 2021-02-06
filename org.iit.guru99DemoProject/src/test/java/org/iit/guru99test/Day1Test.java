package org.iit.guru99test;

import org.guru99helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Day1Test extends TestBase {
	@Test(priority = 0)
	public void validatTitle() {
		/* Launch Application */
		launchApplication(" http://live.demoguru99.com/index.php/");

		/* Verify title of the page */

		String actualTitle = driver.getTitle();
		String expectedTitle = "Home page";
		try {
		Assert.assertEquals(actualTitle, expectedTitle);
		 
		System.out.println("Actual title matches with the expected one");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/* Click on Mobile */
	@Test(priority = 1)
	public void clickOnMobile() {
		driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();

		/* Verify title of the page */
		String actualTitle = driver.getTitle();
		String expectedTitle = "Mobile";
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	/* Select the dorpdown as 'name' */
	@Test(priority = 2)
	public void selectDropDown() {
		Select dropdown = new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]")));
		dropdown.selectByVisibleText("Name");

		/* verify all product is sort by name */

	}

}
