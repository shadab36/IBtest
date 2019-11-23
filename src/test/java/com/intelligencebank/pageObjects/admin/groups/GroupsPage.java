package com.intelligencebank.pageObjects.admin.groups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GroupsPage extends GroupsBasePage {

    @FindAll(@FindBy(xpath = "//div[@class='view__two-column-item']//div[contains(@class,'_truncate_')]/span"))
    private List<WebElement> groups;

    @FindBy(xpath = "//span[contains(.,'Groups')]")
    private WebElement groupsTab;

    public GroupsPage(WebDriver driver) {
        super(driver);
    }

    public void editGroup(String groupName) throws InterruptedException {
        switchToIframe(groupsIframe);
        waitAndAssertVisibility(10, groupsTab, "The groups tabs did not become visible in a timely manner");
        getElementByText(groups, groupName).click();
    }
}
