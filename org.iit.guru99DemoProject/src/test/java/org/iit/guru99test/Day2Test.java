package org.iit.guru99test;

import org.apache.poi.util.SystemOutLogger;
import org.guru99helper.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day2Test extends TestBase {

	String cost1;
	String cost2;

	@Test(priority = 0)
	public void clickOnMobile() {
		/* Launch Application */
		launchApplication(" http://live.demoguru99.com/index.php/");

		/* Click on the Mobile */
		driver.findElement(By.linkText("MOBILE")).click();

	}

	/* Read the cost of sony xperia mobile */
	@Test(priority = 1)
	public void readCostOfSonyXperia() {
		cost1 = driver.findElement(By.className("price")).getText();
		System.out.println(cost1);
	}

	/* Click on sony xperia mobile */
	@Test(priority = 2)
	public void clickOnSonyXperia() {
		driver.findElement(By.linkText("SONY XPERIA")).click();

		cost2 = driver.findElement(By.className("price")).getText();

		System.out.println(cost2);
	}

	/* compare the cost1 and cost 2 */
	@Test(priority = 3)
	public void comparePrize() {
		try {
		Assert.assertEquals(cost1, cost2);
		System.out.println("cost of mobile is matching");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
      driver.quit();
	}
  
}
