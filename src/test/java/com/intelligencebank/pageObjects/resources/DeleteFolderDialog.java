package com.intelligencebank.pageObjects.resources;

import com.intelligencebank.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteFolderDialog extends BasePage {

    @FindBy(css = "input[value='Delete Folder']")
    private WebElement deleteFolderButton;

    public DeleteFolderDialog(WebDriver driver) {
        super(driver);
    }

    public void clickDeleteFolder() {
        switchOutOfIframe();
        waitAndClick(deleteFolderButton, 10);
    }
}
