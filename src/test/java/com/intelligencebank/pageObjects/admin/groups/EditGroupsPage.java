package com.intelligencebank.pageObjects.admin.groups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditGroupsPage extends UsersAsGroupPage {

    public EditGroupsPage(WebDriver driver) {
        super(driver);
    }

    public void switchToGroupsIframe() {
        switchToIframe(groupsIframe);
    }
}
