package com.Basic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class PageScreenshot {

	public static WebDriver driver;

	@BeforeTest
	public void chromeBrowserConfig()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
	}
	
	  @Test
	  public void Screenshot() throws IOException {
		  File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\pageScreenshot.png"),true);
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
}
