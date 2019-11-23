package com.intelligencebank.pageObjects;

import com.intelligencebank.utils.CucumberTestContext;
import com.intelligencebank.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.NoSuchElementException;

public class BasePage {

	protected WebDriver driver;

	@FindBy(xpath="//a[contains(text(),'Admin')]")
	WebElement Admin;	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickMenuAdmin() throws InterruptedException {
		Admin.click();
		Thread.sleep(5000);
	}

	public void waitAndClick(WebElement webElement, long timeOutInSeconds) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click();
	}

	public void switchOutOfIframe() {
		driver.switchTo().defaultContent();
	}

	public void waitAndAssertVisibility(long timeOut, WebElement element, String errorText) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
		try {
			webDriverWait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException ex) {
			Assert.fail(errorText);
		}
	}

	public void selectReactSelectionListOpt(String wantedOption, By menuLocator) {
		WebElement element = driver.findElement(menuLocator)
				.findElement(By.xpath(String.format(".//div[text()='%s']", wantedOption)));
		element.click();
	}

    public void tryClickHandleIframe(WebElement elementToClick, WebElement iframeElement, long timeoutSecs) {
        try{
            waitAndClick(elementToClick, timeoutSecs);
        } catch (NoSuchElementException ex) {
            switchToIframe(iframeElement);
            waitAndClick(elementToClick, timeoutSecs);
        }
    }

    public void switchToIframe(WebElement iframeElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        try {
			webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
		} catch (TimeoutException ex) {
        	// not doing anything with this because you might just want to continue anyway
		}
    }

	protected void takeScreenshot(String screenshotFilename) throws Throwable {
		CucumberTestContext tc = new CucumberTestContext();
		String scenarioName = tc.getScenarioContext().getValue("ScenarioName").toString();

		WebDriverManager webDriverManager = tc.getWebDriverManager();
		webDriverManager.takeScreenshot(scenarioName, screenshotFilename);
	}

	public void goBack() {
		driver.navigate().back();
	}
}
