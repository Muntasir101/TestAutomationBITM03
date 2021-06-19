package com.MultipleWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Base.BaseClass;

public class WindowGUID extends BaseClass {

	public static void main(String[] args) {
		
		launchChrome();
		openTestURL();
		getGUID();
		tearDownChrome();

	}
	
	public static void openTestURL()
	{
		driver.get("https://the-internet.herokuapp.com/windows");
	}
	
	public static void getGUID()
	{
		//String ParentGUID=driver.getWindowHandle();
		//System.out.println(ParentGUID);//CDwindow-0E084E3917612B9D69FD90219AD3DF74
		
		WebElement newWindowBtn=driver.findElement(By.cssSelector("#content > div > a"));
		newWindowBtn.click();
		
		Set<String> allGUID=driver.getWindowHandles();
		System.out.println(allGUID);
		
		System.out.println("Total Window: "+allGUID.size());
		
	}

}
