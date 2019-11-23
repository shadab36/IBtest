package com.intelligencebank.pageObjects.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddFolderPage extends ResourcesBasePage {


    @FindBy(how= How.ID, using = "folderName")
    WebElement FolderNameTextBox;
    @FindBy(how=How.XPATH, using = "//input[@value = 'default']")
    WebElement DefaultRadioButton;
    @FindBy(how=How.XPATH, using = "//input[@value = 'custom']")
    WebElement CustomRadioButton;
    @FindBy(how=How.ID, using = "btnSave")
    WebElement SaveButton;

    public AddFolderPage(WebDriver driver) {
        super(driver);
    }

    public void setFolderName(String foldername) throws InterruptedException
    {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
        String name = foldername + "_" + timeStamp;
        FolderNameTextBox.sendKeys(name);
        Thread.sleep(1000);
    }

    public void selectDefaultRadioButton() throws InterruptedException
    {
        DefaultRadioButton.click();
        Thread.sleep(1000);
    }

    public void clickSaveButton() throws InterruptedException
    {
        SaveButton.click();
        Thread.sleep(5000);
    }

    public void AddNewFolder(String foldername) throws InterruptedException
    {
        driver.switchTo().frame(0);
        Thread.sleep(1000);
        AddButton.click();
        Thread.sleep(1000);
        AddFolderButton.click();
        Thread.sleep(1000);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
        String name = foldername+ "_" + timeStamp;
        FolderNameTextBox.sendKeys(name);
        Thread.sleep(1000);
        DefaultRadioButton.click();
        Thread.sleep(1000);
        SaveButton.click();
        Thread.sleep(5000);
    }
}
