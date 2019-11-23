package com.intelligencebank.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;
	
	@FindBy(how= How.ID, using= "firstname")
	WebElement firstnameTextbox;
	
	@FindBy(how= How.NAME, using= "lastname")
	WebElement lastnameTextbox;
	
	@FindBy(how= How.NAME, using= "email")
	WebElement emailTextbox;
	
	@FindBy(how= How.NAME, using= "submitBtn")
	WebElement registerButton;
	
	public RegistrationPage(WebDriver driver) {	
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void userRegistration(String firstname, String lastname, String email)
	{
		firstnameTextbox.sendKeys(firstname);
		lastnameTextbox.sendKeys(lastname);
		emailTextbox.sendKeys(email);
		registerButton.click();
	}
	
	public void setFirstname(String firstname)
	{
		firstnameTextbox.sendKeys(firstname);
	}
	
	public void setLastname(String lastname)
	{
		lastnameTextbox.sendKeys(lastname);
	}
	
	public void setEmail(String email)
	{
		emailTextbox.sendKeys(email);
	}
	
	public void clickRegisterbutton()
	{
		registerButton.click();
	}
	
	public void verifyRegistrationErrorMessage(String errormessage)
	{
		WebElement ele = driver.findElement(By.xpath("//*[@id='ib-alerts']/div/ul/li"));
		String message = ele.getText();
		Assert.assertEquals(message, errormessage);
	}

}
