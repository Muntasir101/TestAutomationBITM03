package com.Demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Login {

	public static void main(String[] args) {
		AndroidDriver<WebElement> driver = null;

		File app=new File("E:\\Android Test Automation\\carcon-20200513-dev.apk");

		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());

		caps.setCapability("noReset", "true");
		caps.setCapability("deviceName", "Samsung Galaxy M01");
		caps.setCapability("udid", "R8KN40091ZJ"); 
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("appPackage", "com.chokuapp.dev");

		caps.setCapability("appActivity", "com.chokuapp.ui.splash.SplashActivity");


		try {
			driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MobileElement email = (MobileElement) driver.findElement(By.id("com.chokuapp.dev:id/edt_email"));
        email.clear();
        email.sendKeys("muntasir@mail.com");
	
        
        MobileElement password = (MobileElement) driver.findElement(By.id("com.chokuapp.dev:id/edt_password"));
        password .clear();
        password .sendKeys("user123456");
        
        MobileElement loginBtn = (MobileElement) driver.findElement(By.id("com.chokuapp.dev:id/button"));
		loginBtn .click();
		
	}

}
