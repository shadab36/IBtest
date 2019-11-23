package com.intelligencebank.pageObjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class AdminUsersPage extends AdminBasePage {

	@FindBy(xpath="//a[contains(@class,'icon-user-add')]")
	WebElement AddUserIcon;
	
	@FindBy(id="firstname")
	WebElement FirstName;
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(name="email")
	WebElement Email;
  
	@FindBy(css=".select2-input.select2-default")
	WebElement Groups;
	
	@FindBy(xpath="//div[contains(text(),'Preview')]")
	WebElement Select_Group;
	
	@FindBy(xpath="//a[@class='select2-choice']//span[text()='Active User']")
	WebElement Status_user;

	@FindBy(xpath="//input[@type='text'][@autocomplete='new-password']")
	WebElement Staus_input;

	@FindBy(xpath="//ul[@class='select2-results']//li[contains(@class,'select2-highlighte')]")
	WebElement SelectStaus;

	@FindBy(xpath="//input[@value='Yes']")
	WebElement ReactivateUsers;
	
	@FindBy(id="ibKeywordTooltip")
	WebElement Search;
	
	@FindBy(id="searchUserIcon")
	WebElement Search_icon; 
	
	@FindBy(xpath="//a[@title='Delete']")
	WebElement delete_user;

	@FindBy(xpath="//input[@value='Yes']")
	WebElement Confirm_yes;
 
	@FindBy(xpath="(//div[@class='pagerText']//span[text()='0'])[1]")
	WebElement Zero_record;
	
	@FindBy(id="divisionSelectBtn")
	WebElement Select_division;

	@FindBy(xpath="//a[contains(text(),'Div A')]")
	WebElement Division;
	
	@FindBy(id="btnSave")
	WebElement Save;
	
	@FindBy(xpath="//a[contains(text(),'Groups')]")
	WebElement GroupsCTA;


	@FindAll(@FindBy(className = "itemRow"))
	List<WebElement> SearchResults;
 
	public AdminUsersPage(WebDriver driver) {
		super(driver);
	}

	public void clickAddUserIcon() throws InterruptedException {
		try {
			Thread.sleep(2000);
			AddUserIcon.click();
			Thread.sleep(5000);
		
		} catch (Exception e) {
			GroupsCTA.click();
			usersTab.click();
			Thread.sleep(2000);
			AddUserIcon.click();
			Thread.sleep(2000);
		}
	}
	
	public void setFirstName(String firstName) {
		FirstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		lastname.sendKeys(lastName);
	}
	
	public void setEmail(String email) {
		Email.sendKeys(email);
	}	
	
	public void selectUserStatus(String status) throws InterruptedException {
		Status_user.click();
		Thread.sleep(2000);

		Staus_input.sendKeys(status);
		Thread.sleep(1000);

		SelectStaus.click();
		Thread.sleep(1000);
	}
	
	public void selectGroup(String group) {
		Groups.click();

		Select_Group = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'" + group + "')]")));		
		Select_Group.click();
	}

	public void select_division() throws InterruptedException {
		Select_division.click();
		Division = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Div A')]")));
		
		Division.click();
		Thread.sleep(2000);
	}
	
	public void save() throws InterruptedException {
		Save.click(); 
		Thread.sleep(5000);
	}
	
	public void search_user(String email) throws InterruptedException {
        waitAndClick(Search, 10);
        Search.sendKeys(email);
		Search_icon.click();
	}	
	
	public void Delete_record() throws InterruptedException {
		delete_user.click();
		Thread.sleep(1500);

		Confirm_yes.click();
		Thread.sleep(1500);
	}

	public void navigateToUser(String uname) throws InterruptedException {
		clickUserTab();
		search_user(uname);
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		// Waits for the search button to re-appear as it disapears when searching, upon re-appearing (and becoming
		// clickable again) search is complete and ready to continue test
		webDriverWait.until(ExpectedConditions.elementToBeClickable(Search));
		Assert.assertNotEquals(SearchResults.size(),0, String.format("The user %s has not been created yet:", uname));
		Assert.assertEquals(SearchResults.size(),1, "The results returned did not equal the expected number");
		WebElement editUserLink = SearchResults.get(0).findElement(By.linkText(uname));
		editUserLink.click();
	}
}
