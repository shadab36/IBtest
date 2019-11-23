package com.intelligencebank.pageObjects.resources;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.List;

public class ResourcesBasePage extends BasePage {

    protected int desiredFolderIndex;

    @FindBy(id = "phoenix-iframe")
	WebElement resourcesIframe;

	@FindBy(how=How.XPATH, using = "//a[text() = 'Resources']")
	WebElement ResourceMenuLink;
	
	@FindBy(how=How.XPATH, using = ".//*[text()='Add']/ancestor::button")
	WebElement AddButton;
	
	@FindBy(how=How.XPATH, using = "//span[text() = 'Add Folder']")
	WebElement AddFolderButton;

	@FindBy(how=How.XPATH, using = "//textarea[@name = 'description']")
	WebElement DescriptionTextBox;

	@FindBy(how=How.XPATH, using = "//button[@name = 'fsActions[resetBtn]']")
	WebElement ResetButton;
	
	@FindBy(how=How.ID, using = "cancelSubmit")
	WebElement CancelButton;
	
	@FindBy(how=How.XPATH, using = "//*[@id='folderListView']/div[1]/div/div/div[1]/div[1]/div")
	WebElement NewlyCreatedFolderPath;

	@FindAll(@FindBy(xpath = "//*[@id='folderListView']//div[contains(@class,'container')]"))
    List<WebElement> resourceFolders;

    @FindAll(@FindBy(xpath = "//*[@id='folderListView']//div[contains(@class,'container')]//a[contains(@class,'title')]//span"))
    List<WebElement> folderTitles;

    @FindBy(xpath = "//div[contains(@class,'switcher')]//span[contains(.,'folder')]")
    WebElement folderSwitcherButton;

    public ResourcesBasePage(WebDriver driver) {
		super(driver);
	}

	public void clickResourceMenuLink() {
		waitAndClick(ResourceMenuLink, 10);
	}

	public void clickAddButton() {
		tryClickHandleIframe(AddButton, resourcesIframe,3);
	}

	public void clickAddNewFolderButton() {
		tryClickHandleIframe(AddFolderButton, resourcesIframe, 3);
	}

	public void clickNewlyCreatedFolder() {
		tryClickHandleIframe(NewlyCreatedFolderPath, resourcesIframe,3);
	}

    protected void closeActionMenu() throws InterruptedException {
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.ESCAPE);
        builder.sendKeys(Keys.ESCAPE);
        builder.perform();
        Thread.sleep(1000);
    }

    // Had to create a custom wait for the menu to disappear as there is no suitable webdriver wait
    // Element was obscured by menu making it not clickable "ElementClickInterceptedException"
    protected void clickFolderElement(String folderName) throws InterruptedException {
        int numberOfAttempts = 5;
        for (int i = 0; i <= numberOfAttempts; i++) {
            boolean isClicked = false;
            try {
                // Try to click it
                getFolderElement(folderName).click();
                // If it works it will get to this code, set state to isClicked
                isClicked = true;
            } catch (Exception ex) {
                // If it wasn't clicked exception is thrown and you will end up here (it never got to isClicked so that
                // should still be false...

                // But wait for 1 second
                Thread.sleep(1000);
                // ...just to be sure:
                isClicked = false;
                // When we have waited for the correct number of iterations (about 1 second per loop)
                // we want to fail meaningfully and gracefully
                if (i == numberOfAttempts) {
                    Assert.fail("element wasn't clickable as menu hadn't collapsed");
                }
            }
            // If it's been clicked...
            if (isClicked) {
                //...we need to break the loop
                break;
            }
        }
    }

    protected WebElement getFolderElement(String folderName) {
        for (int i = 0; i < resourceFolders.size(); i++) {
            WebElement currentElement = resourceFolders.get(i);
            WebElement nameObject = folderTitles.get(i);
            String currentFolderName = nameObject.getText();
            if(currentFolderName.equals(folderName)) {
                return currentElement;
            }
        }
        return null;
    }

    private void setDesiredFolderIndex(int desiredFolderIndex) {
        this.desiredFolderIndex = desiredFolderIndex;
    }

    protected void setDesiredFolderIndex(String folderName) {
        for (int i = 0; i < resourceFolders.size(); i++) {
            WebElement nameObject = folderTitles.get(i);
            String currentFolderName = nameObject.getText();
            if(currentFolderName.equals(folderName)) {
                setDesiredFolderIndex(i);
            }
        }
    }

    protected int getDesiredFolderIndex() {
        return desiredFolderIndex;
    }

    protected void switchToFolderView() {
        boolean isFolderSwitcherDisplayed = false;
        try {
            isFolderSwitcherDisplayed = folderSwitcherButton.isDisplayed();
        } catch (NoSuchElementException ex) {
            // fall through cos I want to continue anyway
        }

        if (isFolderSwitcherDisplayed) {
            folderSwitcherButton.click();
        }
    }
}
