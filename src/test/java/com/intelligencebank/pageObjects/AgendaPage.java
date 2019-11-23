package com.intelligencebank.pageObjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class AgendaPage {

	public WebDriver driver;
	
	@FindBy(how= How.XPATH, using= "//*[text()='Agenda']")
	WebElement AgendaMenuLink;
	
	@FindBy(how=How.XPATH, using = "//*[@id='moduleToolbar']/span[1]/a")
	WebElement AddAgendaButton;
	
	@FindBy(how=How.XPATH, using = "//*[@name = 'name']")
	WebElement AgendaNameTextBox;
	
	@FindBy(how = How.ID, using = "s2id_calendar")
	WebElement SelectCalenderDropDown;
	
	@FindBy(how = How.ID, using = "s2id_linkCalendarEvent")
	WebElement SelectCalenderEventDropDown;
	
	@FindBy(how=How.XPATH, using = "//input[@value = 'custom']")
	WebElement CustomAgendaTypeRadioButton;
	
	@FindBy(how=How.XPATH, using = "//input[@value = 'synced']")
	WebElement SyncAgendaTypeRadioButton;
	
	@FindBy(how=How.ID, using = "conversationItem")
	WebElement CustomAgendaItemTextBox;
	
	@FindBy(how=How.ID, using = "addConversationItem")
	WebElement CustomAgendaItemAddButton;
	
	@FindBy(how=How.ID, using = "addAgendaItemsBtn")
	WebElement ItemAddButton;
	
	@FindBy(how=How.ID, using = "addSyncedFolderBtn")
	WebElement ItemAddUpdateButon;
	
	@FindBy(how=How.ID, using = "autoNumbering")
	WebElement AutoNumberingCheckBox;
	
	@FindBy(how=How.XPATH, using = "//input[@name = 'collapsable']")
	WebElement CollapsableAgendaCheckBox;
	
	@FindBy(how=How.XPATH, using = "//input[@value = 'default']")
	WebElement IconTypeDefaultRadioButton;
	
	@FindBy(how=How.XPATH, using = "//input[@value = 'custom']")
	WebElement IconTypeCustomRadioButton;
	
	@FindBy(how=How.XPATH, using = "//input[@value = 'Save']")
	WebElement SaveButton;
	
	@FindBy(how=How.XPATH, using = "//button[@name = 'fsActions[exitBtn]']")
	WebElement CancelButton;
	
	@FindBy(how=How.XPATH, using = "//*[@id='agendatoolbarDropdown']")
	WebElement ToolBarDropDown;
	
	@FindBy(how=How.XPATH, using = "//span[text() = 'Copy Agenda']")
	WebElement CopyAgendaLink;
	
	
	
	
	public AgendaPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickAgendaLink()
	{
		AgendaMenuLink.click();
	}
	
	public void clickAddAgenda() throws InterruptedException 
	{
		AddAgendaButton.click();
		Thread.sleep(5000);
	}
	
	public void addcustomAgendaName(String customAgendaName) throws InterruptedException
	{
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());    
		String name = customAgendaName + "_"+ timeStamp;
		AgendaNameTextBox.sendKeys(name);
		Thread.sleep(5000);
	}
	
	public void selectCustomTypeAgenda() throws InterruptedException
	{
		CustomAgendaTypeRadioButton.click();
		Thread.sleep(5000);
	}
	
	public void selectSyncTypeAgenda() throws InterruptedException
	{
		SyncAgendaTypeRadioButton.click();
		Thread.sleep(5000);
	}
	
	public void selectFolderToAdd() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[text() = 'review date test']")).click();
		Thread.sleep(5000);
	}
	
	public void clickAddResourceButton() throws InterruptedException
	{
		ItemAddButton.click();
		Thread.sleep(5000);
	}
	
	public void clickAddUpdateButton() throws InterruptedException
	{
		ItemAddUpdateButon.click();
		Thread.sleep(5000);
	}
	
	public void clickSaveButton() throws InterruptedException
	{
		SaveButton.click();
		Thread.sleep(15000);
	}
	
	public void clickCopyAgenda() throws InterruptedException
	{
		ToolBarDropDown.click();
		Thread.sleep(1000);
		CopyAgendaLink.click();
	}
	

}
