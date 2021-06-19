package com.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllAboutAlert {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();	
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		NormalAlert();
		ConfirmationAlert();
		PromptAlert();
		Browser_close();
	}
	
	public static void NormalAlert() throws InterruptedException
	{
		WebElement AlertBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
		AlertBtn.click();		
		Thread.sleep(5000);		
		driver.switchTo().alert().accept(); // click on Ok button
	}
	
	public static void ConfirmationAlert() throws InterruptedException
	{
		WebElement ConfirmAlertBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
		ConfirmAlertBtn.click();		
		Thread.sleep(5000);		
		driver.switchTo().alert().dismiss(); // click on Cancel button
		Thread.sleep(5000);	
	}
	
	public static void PromptAlert() throws InterruptedException
	{
		String InputText="Test Automation...";
		WebElement PromptmAlertBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
		PromptmAlertBtn.click();		
		Thread.sleep(5000);		
		driver.switchTo().alert().sendKeys(InputText); //Type on Alert		
		driver.switchTo().alert().accept(); // click on Cancel button
		Thread.sleep(5000);	
		
		String OutputText=driver.findElement(By.id("result")).getText();
		
		if(OutputText.contains(InputText))
		{
			System.out.println("Propmt Alert Test pass");
		}
		
		else {
			System.out.println("Propmt Alert Test Fail");
		}
	}
	
	public static void Browser_close()
	{
		driver.quit();
	}

}
