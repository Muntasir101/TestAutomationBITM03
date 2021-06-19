package com.TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class DataProviderTest {

	static WebDriver driver;

	@DataProvider(name="LoginData")
	public Object[][] data()
	{
		Object [][] data=new Object[3][2];

		//1st data set
		data[0][0]="mail1@mail.com";
		data[0][1]="12345";

		//2nd data set
		data[1][0]="mail2@mail.com";
		data[1][1]="12345";

		//3rd data set
		data[2][0]="mail3@mail.com";
		data[2][1]="12345";
		
		return data;
	}
	
	@BeforeMethod
	public void setupBrowser()
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
	}
	
	
	@Test(dataProvider="LoginData")
	public void LoginTest(String email, String password) throws InterruptedException
	{
		
		WebElement Email=driver.findElement(By.id("input-email"));
		WebElement Password=driver.findElement(By.id("input-password"));
		WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

		//Login
		Email.clear();
		Email.sendKeys(email);
		Thread.sleep(2000);
		Password.clear();
		Password.sendKeys(password);
		Thread.sleep(2000);
		LoginBtn.click();	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
