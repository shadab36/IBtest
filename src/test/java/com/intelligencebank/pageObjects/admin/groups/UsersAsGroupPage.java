package com.intelligencebank.pageObjects.admin.groups;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UsersAsGroupPage extends GroupsBasePage {

    @FindAll(@FindBy(xpath = "//div[@class='view__two-column-item']//span[contains(@class,'material-icons')][contains(.,'edit')]"))
    List<WebElement> editUserButtons;

    @FindAll(@FindBy(xpath = "//div[@class='view__two-column-item']//span[contains(@class,'material-icons')][contains(.,'delete')]"))
    List<WebElement> deleteUserButtons;

    @FindBy(xpath = "//span[contains(.,'Permissions')]")
    WebElement permissionsTab;

    @FindAll(@FindBy(xpath = "//tr[contains(.,'Resources')]//input"))
    List<WebElement> permissionSwitches;

    @FindBy(xpath = "//button[contains(.,'Add')]")
    WebElement addButton;

    @FindAll(@FindBy(xpath = "//tr[contains(.,'Resources')]//button[contains(.,'delete')]"))
    List<WebElement> deletePermissionRuleButton;

    @FindBy(xpath = "//tr[contains(.,'Resources')]//span[contains(@class,'Select-arrow-zone')]")
    List<WebElement> resourcePermissionSelectArrows;

    @FindBy(xpath = "//button[contains(.,'Save & Exit')]")
    WebElement saveAndExitButton;

    public UsersAsGroupPage(WebDriver driver) {
        super(driver);
    }

    public void selectEditUserSingleRecord() throws InterruptedException {
        Thread.sleep(2000);
        waitAndClick(editUserButtons.get(0), 10);
    }

    public void selectPermissionsTab() {
        waitAndClick(permissionsTab, 10);
    }

    public void setAccessSwitchOn() {
        int index = 0;
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//tr[contains(.,'Resources')]//input"), 2));
        // If the access switch is turned on there will be more than 3 elements in the collection
        if (permissionSwitches.size() == 3) {
            permissionSwitches.get(index).click();
        }
    }

    public void clickAddDefaultPermissionsRuleButton() {
        waitAndClick(addButton, 10);
    }

    public void deleteAllResourcesPermissions() {
        while (deletePermissionRuleButton.size() > 0) {
            waitAndClick(deletePermissionRuleButton.get(0), 10);
            PageFactory.initElements(driver, this);
        }
    }

    public void selectDefaultPermissionAndSave(String permissionLevel) {
        waitAndClick(resourcePermissionSelectArrows.get(1), 10);
        selectReactSelectionListOpt(permissionLevel, By.cssSelector(".Select-menu-outer"));
        waitAndClick(saveAndExitButton, 10);
        waitAndAssertVisibility(10, usersAsGroupButton,
                "Test fails because save event did not appear to return user to correct page.");
    }

}
