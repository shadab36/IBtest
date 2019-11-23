package com.intelligencebank.pageObjects.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminWorkflowsPage extends AdminBasePage {

    @FindBy(xpath = "//a[contains(text(),'Create Workflow')]")
	WebElement CreateWorkflowButton;

    public AdminWorkflowsPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateWorkflowButton() throws InterruptedException
	{
		Thread.sleep(2500);
		CreateWorkflowButton.click();
		Thread.sleep(1000);
    }
    
}
