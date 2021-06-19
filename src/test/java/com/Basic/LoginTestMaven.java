package com.Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTestMaven {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();	
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		Login_test();
		Title_verification();
		Browser_close();
	}

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
	
	public static void Browser_close()
	{
		driver.quit();
	}

}
