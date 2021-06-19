package com.StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

	WebDriver driver=null;

	@Given("Open Firefox")
	public void open_firefox() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();	

	}

	@When("Open Login page")
	public void open_login_page() {

		driver.get("https://demo.opencart.com/index.php?route=account/login");
	}

	@And("Enter valid email and password")
	public void enter_valid_email_and_password() {

		WebElement Email=driver.findElement(By.id("input-email"));
		WebElement Password=driver.findElement(By.id("input-password"));
		WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

		//Login
		Email.clear();
		Email.sendKeys("mail22@mail.com");
		Password.clear();
		Password.sendKeys("123456");
		LoginBtn.click();
	}

	@Then("Login with this valid credentals")
	public void login_with_this_valid_credentals() {
		//Title Verification
		String Excpected_Title="My Account";
		String Actual_Title=driver.getTitle();

		//Logic Develop
		if(Excpected_Title.equals(Actual_Title))
		{
			System.out.println("Title matched. Test Pass");
		}
		else {
			System.out.println("Title mismatch.Test Fail");
		}
		
		driver.close();
	}

}
