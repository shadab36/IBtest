package com.intelligencebank.pageObjects.resources;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CloneStructurePage extends BasePage {

    @FindBy(xpath = "//a[text()='Resources']")
    WebElement resourcesLink;

    @FindAll(@FindBy(xpath = "//div[@id='cloneModal']//a"))
    List<WebElement> folderLinks;

    @FindBy(css = "input[name='submitBtn'][value='Clone']")
    WebElement cloneButton;

    @FindBy(id = "name")
    WebElement folderTitle;

    @FindBy(id = "cloneModal")
    WebElement cloneFolderStructureDialog;

    public CloneStructurePage(WebDriver driver) {
        super(driver);
    }

    public void selectFolder(String folderName) {
        switchOutOfIframe();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(resourcesLink));
        for(int i = 0; i < folderLinks.size(); i++) {
            WebElement folderLink = folderLinks.get(i);
            String folderLinkText = folderLink.getText();
            if(folderLinkText.equals(folderName)){
                folderLink.click();
                break;
            }
        }
    }

    public void clickCloneButton() {
        waitAndClick(cloneButton, 10);
    }

    public void enterFolderName(String folderName) {
        folderTitle.clear();
        folderTitle.sendKeys(folderName);
    }

    public void waitForDialogToDisapear() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOf(cloneFolderStructureDialog));
    }
}
