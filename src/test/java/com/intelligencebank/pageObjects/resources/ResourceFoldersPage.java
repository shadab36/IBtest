package com.intelligencebank.pageObjects.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ResourceFoldersPage extends ResourcesBasePage {

    @FindBy(css = "[style='display: inline;']")
    List<WebElement> folderViews;

    private By actionsButtonLocator = By.xpath("//*[@id='folderListView']//div[contains(@class,'container')]//button");
    @FindAll(@FindBy(xpath = "//*[@id='folderListView']//div[contains(@class,'container')]//button"))
    List<WebElement> resourceFolderActionButtons;

    @FindAll(@FindBy(css = "div[role='menu'] span.action-menu-item span"))
    List<WebElement> folderActionsList;

    @FindBy(xpath = "//span[text()='home']")
    WebElement homeBreadcrumb;

    public ResourceFoldersPage(WebDriver driver) {
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
    public void iterateOverFoldersAssertingPermissions(List<Map<String, String>> dataTable) throws Throwable {
        for (int i = 0; i < dataTable.size(); i++) {
            switchToIframe(resourcesIframe);
            switchToFolderView();

            Map<String, String> tableRow = dataTable.get(i);
            String folderName = tableRow.get("Folder");

            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            try {
                webDriverWait.until(ExpectedConditions.visibilityOfAllElements(resourceFolders));
            } catch(Exception ex) {
                // no need to do anything here
            }

            // click the actions menu button - have to click twice or JS event doesn't fire
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
                clickFolderActionButton(folderName);
                Thread.sleep(1000);
                clickFolderActionButton(folderName);
                Thread.sleep(1000);
                folderPermissionAssertions(tableRow, folderName);
            }
        }
    }

    public void clickFolderActionButton(String folderName) {
        switchToIframe(resourcesIframe);
        setDesiredFolderIndex(folderName);
        int desiredFolderIndex = getDesiredFolderIndex();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                actionsButtonLocator));
        WebElement element = resourceFolderActionButtons.get(desiredFolderIndex);
        element.click();
    }

    public void selectCloneStructure() throws Throwable {
        String item = "Clone Structure";
        waitAndClick(folderOptionElement(folderActionsList, item), 10);
    }

    public void selectDeleteFolder() throws Throwable {
        String item = "Delete Folder";
        waitAndClick(folderOptionElement(folderActionsList, item), 10);
    }

    private void folderPermissionAssertions(Map<String, String> tableRow, String folderName) throws Throwable {
        if (tableRow.get("Delete").equals("No")) {
            assertFolderOptionNotPresent(folderActionsList, "Delete Folder");
        } else if (tableRow.get("Delete").equals("Yes")) {
            assertFolderOptionPresent(folderActionsList, "Delete Folder");
        }

        if (tableRow.get("Create Sub Folder").equals("No")) {
            assertFolderOptionNotPresent(folderActionsList, "Add Folder");
        } else if (tableRow.get("Create Sub Folder").equals("Yes")) {
            assertFolderOptionPresent(folderActionsList, "Add Folder");
        }

        if (tableRow.get("Change Settings").equals("No")) {
            assertFolderOptionNotPresent(folderActionsList, "Folder Settings");
        } else if (tableRow.get("Change Settings").equals("Yes")) {
            assertFolderOptionPresent(folderActionsList, "Folder Settings");
        }

        if (tableRow.get("Add File").equals("No")) {
            closeActionMenu();
            clickFolderElement(folderName);
            Assert.assertFalse(isAddButtonPresent(), "Button was not supposed to be displayed onscreen but was");
        } else if (tableRow.get("Add File").equals("Yes")) {
            closeActionMenu();
            clickFolderElement(folderName);
            Assert.assertTrue(isAddButtonPresent(), "Button was supposed to be displayed onscreen but was not");
        }
    }

    private boolean isAddButtonPresent() {
        boolean isDisplayed;
        try {
            isDisplayed = AddButton.isDisplayed();
        } catch (NoSuchElementException ex) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    private void assertFolderOptionNotPresent(List<WebElement> folderActionsList, String folderOption) throws Throwable {
        boolean isPresent = isFolderOptionPresent(folderActionsList, folderOption);
        takeScreenshot(String.format("%s_Not_Permitted", folderOption));
        Assert.assertFalse(isPresent,
                String.format("The Option '%s' was in the list and it wasn't supposed to be", folderOption));
    }

    private void assertFolderOptionPresent(List<WebElement> folderActionsList, String folderOption) throws Throwable {
        boolean isPresent = isFolderOptionPresent(folderActionsList, folderOption);
        takeScreenshot(String.format("%s_Permitted", folderOption));
        Assert.assertTrue(isPresent,
                String.format("The Option '%s' was not in the list and it was supposed to be", folderOption));
    }

    private boolean isFolderOptionPresent(List<WebElement> folderActionsList, String folderOption) {
        boolean isPresent = false;
        for (int i = 0; i < folderActionsList.size(); i++) {
            WebElement currentFolderAction = folderActionsList.get(i);
            if(currentFolderAction.getText().equals(folderOption)) {
                isPresent = true;
            }
        }
        return isPresent;
    }

    private WebElement folderOptionElement(List<WebElement> folderActionsList, String folderOption) {
        for (int i = 0; i < folderActionsList.size(); i++) {
            WebElement currentFolderAction = folderActionsList.get(i);
            if(currentFolderAction.getText().equals(folderOption)) {
                return currentFolderAction;
            }
        }
        return null;
    }

    public void waitForResourcesPage() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = resourceFolderActionButtons.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
