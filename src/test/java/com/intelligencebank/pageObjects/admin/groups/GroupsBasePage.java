package com.intelligencebank.pageObjects.admin.groups;

import com.intelligencebank.pageObjects.admin.AdminBasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GroupsBasePage extends AdminBasePage {

    @FindBy(id = "phoenix-iframe")
    WebElement groupsIframe;

    @FindBy(xpath = "//button[contains(.,'Groups')]")
    WebElement groupsButton;

    @FindBy(xpath = "//span[contains(.,'Users As Group')]")
    WebElement usersAsGroupButton;

    @FindBy(xpath = "//span[contains(@class, 'material-icons')][contains(.,'search')]")
    WebElement searchButton;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchField;

    public GroupsBasePage(WebDriver driver) {
        super(driver);
    }

    public void waitAndClickGroupsTab() {
        waitAndClick(groupsButton, 10);
    }

    public void waitAndClickUsersAsGroupTab() {
        switchToIframe(groupsIframe);
        waitAndClick(usersAsGroupButton, 15);
    }

    public void useSearch(String searchItem) {
        waitAndClick(searchButton, 10);
        waitAndClick(searchField, 10);
        searchField.sendKeys(searchItem);
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.ENTER);
        builder.build();
    }
}
