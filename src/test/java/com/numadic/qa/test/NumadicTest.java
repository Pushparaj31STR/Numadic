package com.numadic.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import com.numadic.base.BaseClass;


public class NumadicTest extends BaseClass{
	
	public static WebDriver driver;

	@BeforeSuite
	private void setUp() throws Exception {
		driver = browserLaunch("chrome");
	}
	
	@BeforeTest
	private void url() throws Exception {
		getUrl("https://jobs.numadic.com/jobs/Careers");
	}
	
	@Test(priority = 1)
	private void validateHeader() throws Exception {
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='JOIN OUR CREW']")).isDisplayed());
	}
	
	@Test(priority = 2)
	private void validateFilter() throws Exception {
		driver.findElement(By.xpath("//lyte-icon[@class='dropdown']")).click();
		driver.findElement(By.xpath("//lyte-drop-item[text()='Engineering']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("<a class=\"cw-1-title\" data-zrqa=\"cw-job1-name1\" href=\"https://jobs.numadic.com/jobs/Careers/53264000000375218/QA-Engineer?source=CareerSite\" style=\"color:#5D9EE3\">QA Engineer</a>")).click();
	}
	
	@Test(priority = 3)
	private void qaEngineering() throws Exception {
		String expectedTitle = "Numadic Iot Pvt. Ltd. - QA Engineer in";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(driver.findElement(By.xpath("(//lyte-yield[text()=\"I'm interested\"])[1]")).isEnabled());
		
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("(//lyte-yield[text()=\"I'm interested\"])[1]"))).click().build().perform();
		
		driver.findElement(By.xpath("(//lyte-icon[@class='dropdown'])[1]")).click();
		driver.findElement(By.xpath("//lyte-drop-item[text()='Mr.']")).click();
		
		List<WebElement> fields = driver.findElements(By.xpath("//input[@type='text']"));
		
		for (int i = 0; i < fields.size(); i++) {
			WebElement field = fields.get(i);
			switch (i) {
			case 0:
				field.sendKeys("Pushparaj");
				break;
			case 1:
				field.sendKeys("Kumaraguru");
				break;
			case 2:
				field.sendKeys("Pushparaj");
				break;
			case 3:
				field.sendKeys("pushparaj@gmail.com");
				break;
			case 4:
				field.sendKeys("8989898989");
				break;
			case 5:
				field.sendKeys("xxxxx");
				break;
			case 6:
				field.sendKeys("yyyyy");
				break;
			case 7:
				field.sendKeys("zzzzz");
				break;
			case 8:
				field.sendKeys("123456");
				break;
			case 9:
				field.sendKeys("Chennai");
				break;
			case 10:
				field.sendKeys("Ebix Softwares India");
				break;
			case 11:
				field.sendKeys("ABC");
				break;
			case 12:
				field.sendKeys("10LPA");
				break;
			case 14:
				field.sendKeys("Career growth");
				break;
			default:
				break;
			}
		}
	}
	
	
	
}
