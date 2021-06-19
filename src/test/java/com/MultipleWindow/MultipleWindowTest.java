package com.MultipleWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Base.BaseClass;

public class MultipleWindowTest extends BaseClass {

	public static void main(String[] args) {

		launchChrome();
		WindowGUID.openTestURL();
		switchMultipleWindow();
		tearDownChrome();

	}

	public static void switchMultipleWindow()
	{
		String ParentGUID=driver.getWindowHandle();

		WebElement newWindowBtn=driver.findElement(By.cssSelector("#content > div > a"));
		newWindowBtn.click();

		Set<String> allGUID=driver.getWindowHandles();
		System.out.println(allGUID);

		System.out.println("Total Window: "+allGUID.size());

		//Iterate the value in set. Switch to Child
		for(String ChildGUID:allGUID)
		{
			if(!ChildGUID.equals(ParentGUID))
			{
				driver.switchTo().window(ChildGUID);
				System.out.println("Child Window Title: "+driver.getTitle());

				break;
			}
		}

		//switch to parent
		for(String ChildGUID:allGUID)
		{
			if(!ChildGUID.equals(ParentGUID))
			{
				driver.switchTo().window(ParentGUID);
				System.out.println("After switch to parent Window Title: "+driver.getTitle());

				break;
			}
		}

		// Switch to Child
		for(String ChildGUID:allGUID)
		{
			if(!ChildGUID.equals(ParentGUID))
			{
				driver.switchTo().window(ChildGUID);
				System.out.println("Again switch Child Window Title: "+driver.getTitle());

				break;
			}
		}
	}
}

