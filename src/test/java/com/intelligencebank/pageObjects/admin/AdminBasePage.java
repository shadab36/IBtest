package com.intelligencebank.pageObjects.admin;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class AdminBasePage extends BasePage {

	@FindBy(xpath = "//a[contains(.,'Groups')]")
	WebElement groupsTab;

	@FindBy(xpath="//a[contains(text(),'Users')]")
	WebElement usersTab;
	
	@FindBy(xpath="//*[text()='Workflows']")
	WebElement workflowsTab;

	public AdminBasePage(WebDriver driver) {
		super(driver);
	}

	public void clickGroupsTab() {
		waitAndClick(groupsTab, 10);
		waitAndClick(groupsTab, 10);
	}

	public void clickUserTab() throws InterruptedException {
		waitAndClick(usersTab, 10);
	}

	public void clickWorkflowsTab() throws InterruptedException {
		workflowsTab.click();
	}

	protected WebElement getElementByText(List<WebElement> elements, String desiredText) throws InterruptedException {
		Thread.sleep(1000);
		for(int i = 0; i < elements.size(); i++) {
			String elementText = elements.get(i).getText();
			if(elementText.equals(desiredText)) {
				return elements.get(i);
			}
		}
		return null;
	}
}
