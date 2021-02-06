package org.iit.guru99test;

import java.util.Iterator;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.guru99helper.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Dya4Test extends TestBase {

	/* Click on Mobile */
	@Test(priority = 0)
	public void clickOnMobile() {

		/* Launch Application */
		launchApplication(" http://live.demoguru99.com/index.php/");

		driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();

	}

	/* Click on add to compare */
	@Test(priority = 1)
	public void clickAddToCompare() {
		driver.findElement(By.xpath("(//a[@class='link-compare'])[1]")).click();
		driver.findElement(By.xpath("(//a[@class='link-compare'])[2]")).click();
		driver.findElement(By.xpath("//button[@title='Compare']")).click();
	}

	/* Verify the pop-up window */
	@Test(priority = 2)
	public void verifyPopUPWindow() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		// fetch the parent window handles
		String parentid = it.next();
		System.out.println(parentid);

		// fetch the child window handle
		String childwinid = it.next();
		System.out.println(childwinid);

		driver.switchTo().window(childwinid);

		driver.manage().window().maximize();

		String childwinidtitleAct = driver.findElement(By.xpath("//div[@class='page-title title-buttons']/h1"))
				.getText();

		System.out.println("Pop-up window Actual title is" + childwinidtitleAct);

		String childwinidtitleExp = "COMPARE PRODUCTS";

		System.out.println("Pop-up window Expected title is" + childwinidtitleExp);

		if (childwinidtitleAct.equals(childwinidtitleExp)) {
			System.out.println("Actual Pop-up window title match with the expected one ");

		} else {
			System.out.println("Actual Pop-up window title does match with the expected one ");
		}

		/* Verify both the products refecled in pop-up window */

		String childwinprod1 = driver.findElement(By.xpath("(//h2[@class='product-name'])[1]")).getText();
		String childwinprod2 = driver.findElement(By.xpath("(//h2[@class='product-name'])[2]")).getText();

		driver.switchTo().window(parentid);

		String parentwinProd1 = driver.findElement(By.xpath("//a[@title='Sony Xperia']")).getText();
		String parentwinProd2 = driver.findElement(By.xpath("(//a[@title='IPhone'])[2]")).getText();

		System.out.println("These are the parent window products to compare" + parentwinProd1 + parentwinProd2);

		System.out.println("These are the child window products to compare" + childwinprod1 + childwinprod2);
		if (parentwinProd1.equals(childwinprod1) && parentwinProd2.equals(childwinprod2)) {
			System.out.println("Pop-up window reflecting the Two comparing products ");

		} else {
			System.out.println("Pop-up window is not reflecting the Two comparing products ");

		}

		driver.quit();
	}

}
