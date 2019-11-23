package com.intelligencebank.pageObjects.resources;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.intelligencebank.helper.DropFileHelper;

public class AddNewResourcePage {
	
	WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[text()='Add Resource']/ancestor::div[2]")
	WebElement AddResourceButton;
	
	@FindBy(how=How.XPATH, using = "//input[@value = 'file']")
	WebElement FileRadioButton;
	
	@FindBy(how=How.XPATH, using = "//input[@value = 'url']")
	WebElement WebUrlRadioButton;
	
	@FindBy(how=How.XPATH, using = " //*[text() = ' Select file']")
	WebElement SelectFileButton;
	
	@FindBy(how=How.ID, using = "name")
	WebElement NameTextBox;
	
	@FindBy(how=How.XPATH, using = "description")
	WebElement DescriptionTextBox;
	
	@FindBy(how=How.XPATH, using = "//input[@value = 'none']")
	WebElement NoneRadioButton;
	
	@FindBy(how=How.XPATH, using = "//input[@value = 'image']")
	WebElement ImageRadioButton;
	
	@FindBy(how=How.XPATH, using = "//input[@value = 'userdetails']")
	WebElement UserDetailsRadioButton;
	
	@FindBy(how=How.XPATH, using = "//input[@value = 'default']")
	WebElement DefaultRadioButton;
	
	@FindBy(how=How.XPATH, using = "//input[@value = 'custom']")
	WebElement CustomRadioButton;
	
	@FindBy(how=How.ID, using = "btnSave")
	WebElement SaveButton;
	
	@FindBy(how=How.XPATH, using = "//button[@name = 'fsActions[resetBtn]']")
	WebElement ResetButton;
	
	@FindBy(how=How.ID, using = "cancelSubmit")
	WebElement CancelButton;
	
	@FindBy(how=How.XPATH, using = "//a[text() = 'Continue']")
	WebElement ContinueButton;
	
	@FindBy(how=How.XPATH, using = "//input[@type = 'file']")
	WebElement FileUpload;
	
	public AddNewResourcePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickAddResourceButton() throws InterruptedException
	{
		AddResourceButton.click();
		Thread.sleep(2000);
	}
	
	public void clickFileRadioButton() throws InterruptedException
	{
		FileRadioButton.click();
		Thread.sleep(1000);		
	}
	
	public void setName(String name) throws InterruptedException
	{
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
		String newname = name+ "_" + timeStamp;
		NameTextBox.sendKeys(newname);
		Thread.sleep(1000);
	}
	
	public void clickwatermarkType() throws InterruptedException
	{
		NoneRadioButton.click();
		Thread.sleep(1000);
	}
	
	public void clickfileiconType() throws InterruptedException
	{
		DefaultRadioButton.click();
		Thread.sleep(1000);
	}
	
	public void clickSaveButton() throws InterruptedException
	{
		SaveButton.click();
		Thread.sleep(5000);
	}
	
	public void uploadSingleFile() throws InterruptedException
	{			
		WebElement droparea = driver.findElement(By.xpath("//*[text() = ' Select file']"));

		// drop the file
		DropFileHelper.DropFile(new File("./src/test/java/filestoupload/test.pdf"), droparea, 0, 0);
		Thread.sleep(2000);
		ContinueButton.click();
		Thread.sleep(1000);
	}
	
	
}
