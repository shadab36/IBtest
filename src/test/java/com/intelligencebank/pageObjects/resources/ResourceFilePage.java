package com.intelligencebank.pageObjects.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ResourceFilePage extends ResourcesBasePage {

    private String fileLocator = "//div[contains(@class,'_container_')][contains(.,'%s')]";

    private By readerButtonLocator = By.xpath("//button[contains(.,'reader')]");

    private By downloadButtonLocator = By.xpath("//button[contains(.,'file_download')]");

    private By infoButtonLocator = By.xpath("//button[contains(.,'info')]");

    private String actionMenuButton = "//div[contains(@class,'_container_')][contains(.,'%s')]//button[contains(.,'more_vert')]";

    @FindAll(@FindBy(xpath = "//div[contains(@class,'file-name')]//span"))
    List<WebElement> filenames;

    @FindAll(@FindBy(css = "div[role='menu'] span.action-menu-item span"))
    List<WebElement> fileActionsList;

    public ResourceFilePage(WebDriver driver) {
        super(driver);
    }

    // For Permissions Testing Only - Will be tightly coupled to test data
    // USER AS GROUP folder Resource Folder Structure:
    // Folder G1
    //      |___File G1.1
    //      |___Folder G2
    //              |___File G2.1
    //              |___Folder G3
    //                      |___File G3.1
    public void iterateOverFilesAssertingPermissions(List<Map<String, String>> dataTable) throws Throwable {
        for (int i = 0; i < dataTable.size(); i++) {
            Map<String, String> tableRow = dataTable.get(i);
            String fileName = tableRow.get("Filenames");
            String folderName = fileName.substring(0, fileName.indexOf("."));

            switchToIframe(resourcesIframe);
            closeActionMenu();

            if (tableRow.get("Delete").equals("Hidden")) {
                boolean displayed;
                try {
                    displayed = folderSwitcherButton.isDisplayed();
                } catch (NoSuchElementException ex) {
                    displayed = false;
                }
                takeScreenshot("Folder_Hidden");
                Assert.assertFalse(displayed);
            } else {
                switchToFolderView();
                clickFolderElement(folderName);

                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.visibilityOfAllElements(filenames));
                filePermissionAssertions(tableRow, fileName);
            }
        }
    }

    private void filePermissionAssertions(Map<String, String> tableRow, String fileName) throws Throwable {
        Thread.sleep(1000);
        if(tableRow.get("Preview").equals("Yes")) {
            takeScreenshot("Preview_Permitted");
            Assert.assertTrue(isReaderButtonPresent(fileName), "Preview button was not displayed but it was supposed to be");
        } else if(tableRow.get("Preview").equals("No")) {
            takeScreenshot("Preview_Not_Permitted");
            Assert.assertFalse(isReaderButtonPresent(fileName),
                    "Preview button was displayed but the user didn't have permission to view it");
        }

        if(tableRow.get("Download").equals("Yes")) {
            takeScreenshot("Download_Permitted");
            Assert.assertTrue(isDownloadButtonPresent(fileName), "Download button was not displayed and it should have been");
        } else if(tableRow.get("Download").equals("No")) {
            takeScreenshot("Download_Not_Permitted");
            Assert.assertFalse(isDownloadButtonPresent(fileName),
                    "Download button was displayed but the user didn't have permission to view it");
        }

        if(tableRow.get("Read Info").equals("Yes")) {
            takeScreenshot("Read_Info_Permitted");
            Assert.assertTrue(isInfoButtonPresent(fileName), "Info button was displayed and it should not have been");
        } else if(tableRow.get("Read Info").equals("No")) {
            takeScreenshot("Read_Info_Not_Permitted");
            Assert.assertFalse(isInfoButtonPresent(fileName),
                    "Info button was displayed but the user didn't have permission to view it");
        }

        driver.findElement(By.xpath(String.format(actionMenuButton, fileName))).click();

        String positiveError = "The menu option %s was supposed to be displayed but was not";
        String negativeError = "The the user does nto have permission to see the menu option %s but is it displayed";

        if(tableRow.get("Delete").equals("Yes")) {
            String expectedMenuText = "Delete Resource";
            takeScreenshot(String.format("%s_Permitted", expectedMenuText));
            boolean isOptionPresent = isFileOptionPresent(fileActionsList, expectedMenuText);
            Assert.assertTrue(isOptionPresent, String.format(positiveError, expectedMenuText));
        } else if(tableRow.get("Delete").equals("No")) {
            String expectedMenuText = "Delete Resource";
            takeScreenshot(String.format("%s_Not_Permitted", expectedMenuText));
            boolean isOptionPresent = isFileOptionPresent(fileActionsList, expectedMenuText);
            Assert.assertFalse(isOptionPresent, String.format(negativeError, expectedMenuText));
        }
    }

    protected WebElement getFileElement(String fileName) {
        String locator = String.format(fileLocator, fileName);
        return driver.findElement(By.xpath(locator));
    }

    private boolean isReaderButtonPresent(String fileName) {
        return isButtonPresent(fileName, readerButtonLocator);
    }

    private boolean isDownloadButtonPresent(String fileName) {
        return isButtonPresent(fileName, downloadButtonLocator);
    }

    private boolean isInfoButtonPresent(String fileName) {
        return isButtonPresent(fileName, infoButtonLocator);
    }

    private boolean isButtonPresent(String fileName, By by) {
        boolean displayed;
        try {
            displayed = getFileElement(fileName).findElement(by).isDisplayed();
        } catch (NoSuchElementException ex) {
            displayed = false;
        }
        return displayed;
    }

    private boolean isFileOptionPresent(List<WebElement> fileActionsList, String fileOption) {
        for (int i = 0; i < fileActionsList.size(); i++) {
            WebElement currentFileAction = fileActionsList.get(i);
            String currentFileText = currentFileAction.getText();
            if(currentFileText.equals(fileOption)) {
                return true;
            }
        }
        return false;
    }
}
