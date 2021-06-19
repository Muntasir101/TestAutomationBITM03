package com.DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();	
		driver.get("https://the-internet.herokuapp.com/dropdown");

		selectDropdownValue();
		selectDropdownIndex();
		selectDropdownVisibleText();
	}

	public static void selectDropdownValue() throws InterruptedException
	{
		WebElement Dropdown=driver.findElement(By.cssSelector("#dropdown"));	
		Select obj=new Select(Dropdown);	
		obj.selectByValue("2");		
	   Thread.sleep(5000);
	}

	public static void selectDropdownIndex() throws InterruptedException
	{
		WebElement Dropdown=driver.findElement(By.cssSelector("#dropdown"));	
		Select obj=new Select(Dropdown);	
		obj.selectByIndex(1);
		Thread.sleep(5000);
	}
	
	public static void selectDropdownVisibleText() throws InterruptedException
	{
		WebElement Dropdown=driver.findElement(By.cssSelector("#dropdown"));	
		Select obj=new Select(Dropdown);	
		obj.selectByVisibleText("Option 2");
		Thread.sleep(5000);
	}

}
