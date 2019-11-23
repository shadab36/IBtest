package com.intelligencebank.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

	public WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
	public WebElement LogoutLink;

	@FindBy(id = "menu-userDetail")
	WebElement userDetailMenu;

	@FindBy(linkText = "Resource")
	WebElement resourceButton;

	@FindBy(linkText = "Logout")
	WebElement logoutMenuOption;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public boolean logoutLinkExists() throws InterruptedException
	{		
		try	{
			WebElement logoutLinkExist = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			return (logoutLinkExist != null);	
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean login() {
		return this.LogoutLink.isDisplayed();
	}

	public void logoutFromMenu() {
		waitAndClick(userDetailMenu, 10);
		waitAndClick(logoutMenuOption, 10);
	}

	public void clickResourceButton() {
		waitAndClick(resourceButton, 10);
	}
}
