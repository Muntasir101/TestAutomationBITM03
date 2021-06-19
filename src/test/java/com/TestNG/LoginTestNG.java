package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginTestNG {
	
	public static WebDriver driver;

	@BeforeTest
	public void chromeBrowserConfig()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
	}
	
	@AfterTest
	public static void tearDownChrome()
	{
		if(driver!=null)
		{
			driver.quit();
		}		
		else {
			System.out.println("No driver found.");
		}	
	}
	
	@Test(description="Email and password are invalid")
	public static void Login_test()
	{
		
		WebElement Email=driver.findElement(By.id("input-email"));
		WebElement Password=driver.findElement(By.id("input-password"));
		WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

		//Login
		Email.clear();
		Email.sendKeys("test@test.com");
		Password.clear();
		Password.sendKeys("121212");
		LoginBtn.click();
	}

	@Test
	public static void Title_verification()
	{
		//Title Verification
		String Excpected_Title="Account Login";
		String Actual_Title=driver.getTitle();

		//Logic Develop
		if(Excpected_Title.equals(Actual_Title))
		{
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}

	}
}
