package com.intelligencebank.pageObjects;

import com.intelligencebank.utils.CucumberTestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(how = How.NAME, using = "username")
	WebElement usernameTextbox;
	
	@FindBy(how = How.NAME, using = "password")
	WebElement passwordTextbox;

	@FindBy(how = How.NAME, using = "submitBtn")
	WebElement Loginbutton;

	@FindBy(how = How.XPATH, using = "//*[@id='ib-alerts']/div/ul/li" )
	WebElement errormessage;	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
		
	public void clickLoginButton()
	{
		Loginbutton.click();
	}
	
	public void setUsername(String username)
	{
		usernameTextbox.clear();
		usernameTextbox.sendKeys(username);		
	}
	
	public void setPassword(String password)
	{
		passwordTextbox.clear();
		passwordTextbox.sendKeys(password);
	}

	public void loginAdmin(CucumberTestContext cucumberTestContext) {
		String username = cucumberTestContext.getCredentialsManager().getAdminUsername();
		String password = cucumberTestContext.getCredentialsManager().getAdminPassword();
		login(username, password);
	}

	public void login(CucumberTestContext cucumberTestContext, String uname) {
		String password = cucumberTestContext.getCredentialsManager().getGroupPermissionsPassword(uname);
		String userLogin = String.format("%s@intelligencebank.com", uname.toLowerCase());
		login(userLogin, password);
	}

	public void login(String username, String password)
	{
		setUsername(username);
		setPassword(password);

		Loginbutton.click();
	}	

	public String getErrorMessage()
	{
		return errormessage.getText();
	}
}
