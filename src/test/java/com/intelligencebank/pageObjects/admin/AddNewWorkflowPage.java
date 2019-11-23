package com.intelligencebank.pageObjects.admin;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.intelligencebank.pageObjects.BasePage;

public class AddNewWorkflowPage extends BasePage {
		
	@FindBy(how=How.ID, using = "name")
	WebElement WorkflowNameTextBox;
	
	@FindBy(how=How.ID, using = "s2id_type")
	WebElement WorkflowTypeDropDown;
	
	@FindBy(how=How.ID, using = "s2id_tool")
	WebElement ToolDropDown;
	
	@FindBy(how=How.ID, using = "workflowStageType")
	WebElement StandardRadioButton;
	
	@FindBy(how=How.ID, using = "")
	WebElement StagedRadioButton;
	
	@FindBy(how=How.ID, using = "mandatory")
	WebElement GlobalYesRadioButton;
	
	@FindBy(how=How.ID, using = "")
	WebElement GlobalNoRadioButton;
	
	@FindBy(how=How.XPATH, using = "//*[text()='Mandatory: ']/following::label[1]")
	WebElement MandatoryYesRadioButton;
	
	@FindBy(how=How.XPATH, using = "//*[text()='Mandatory: ']/following::label[2]")
	WebElement MandatoryNoRadioButton;
	
	@FindBy(how=How.XPATH, using = "//*[@id='workflow']/div[8]/div/div/div/label[4]/input")
	WebElement ReviewRequestUserRadioButton;
	
	@FindBy(how=How.XPATH, using = "")
	WebElement DirectLeaderRadioButton;
	
	@FindBy(how=How.XPATH, using = "")
	WebElement LeadersRadioButton;
	
	@FindBy(how=How.XPATH, using = "s2id_reviewerType")
	WebElement ReviewerNominationTypeDropDown;
	
	@FindBy(how = How.ID, using = "autoCompleteOnDecline")
	WebElement AutomCompleteYesButton;
	
	@FindBy(how = How.ID, using = "")
	WebElement AutomCompleteNoButton;
	
	@FindBy(how = How.ID, using = "approveWithComment")
	WebElement ApproveWithCommentYesButton;
	
	@FindBy(how = How.ID, using = "")
	WebElement ApproveWithCommentNoButton;
	
	@FindBy(how = How.ID, using = "requiredByField")
	WebElement RequiredByFieldYesRadioButton;
	
	@FindBy(how = How.ID, using = "")
	WebElement RequiredByFieldNoRadioButton;
	
	@FindBy(how=How.ID, using = "requireDetails")
	WebElement CommentYesButton;
	
	@FindBy(how=How.ID, using = "")
	WebElement CommentNoButton;
	
	@FindBy(how=How.XPATH, using = "//*[@id='workflow']/div[25]/div/div/div/label[1]/input")
	WebElement CommentsFieldTypeBasicRadioButton;
	
	@FindBy(how=How.XPATH, using = "//input[@name = 'userNotifications' and @value = '0']")
	WebElement UserNotificationAllRadioButton;
	
	@FindBy(how=How.XPATH, using = "//input[@name = 'userNotifications' and @value = '1']")
	WebElement UserNotificationSelectRadioButton;
	
	@FindBy(how=How.XPATH, using = "//*[@id='workflow']/div[6]/div/div/div/label[1]/input")
	WebElement RequestDefaultTypeRadioButton;
	
	@FindBy(how=How.XPATH, using = "")
	WebElement RequestCustomTypeRadioButton;
	
	@FindBy(how=How.ID, using = "btnSave")
	WebElement SaveButton;	
	
	public AddNewWorkflowPage(WebDriver driver) {	
		super(driver);	
	}
	
	public void setName(String workflowname) throws InterruptedException
	{
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
		String newname = workflowname+ "_" + timeStamp;
		WorkflowNameTextBox.sendKeys(newname);
		Thread.sleep(1000);
	}
	
	public void selectWorkflow(String workflowtype) throws InterruptedException
	{
		if(workflowtype.equalsIgnoreCase("Publish") )
		{
			WorkflowTypeDropDown.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(text(),'Workflow Type')]/following::li//*[text()='Publish']")).click();
			Thread.sleep(1000);			
		}
		else if(workflowtype.equalsIgnoreCase("Feedback"))
		{
			WorkflowTypeDropDown.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(text(),'Workflow Type')]/following::li//*[text()='Feedback']")).click();
			Thread.sleep(1000);
		}
		else if(workflowtype.equalsIgnoreCase("Download"))
		{
			WorkflowTypeDropDown.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(text(),'Workflow Type')]/following::li//*[text()='Download']")).click();
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("No such workflow exists");
		}
	}
	
	public void selectToolType(String tooltype) throws InterruptedException
	{
		if(tooltype.equalsIgnoreCase("Resources"))
		{
			ToolDropDown.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='select2-drop']/ul/li[1]/div/div")).click();
			Thread.sleep(1000);
		}
		else if(tooltype.equalsIgnoreCase("Databases"))
		{
			ToolDropDown.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='select2-drop']/ul/li[2]/div/div")).click();
			Thread.sleep(1000);
		}
		else if(tooltype.equalsIgnoreCase("Survey"))
		{
			ToolDropDown.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='select2-drop']/ul/li[3]/div/div")).click();
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("No such tool exists");
		}
	}
	
	public void selectReviewProcess(String reviewprocess) throws InterruptedException
	{
		if(reviewprocess.equalsIgnoreCase("Standard"))
		{
			StandardRadioButton.click();
			Thread.sleep(1000);
		}
		else if(reviewprocess.equalsIgnoreCase("Staged"))
		{
			StagedRadioButton.click();
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("Review process not available");
		}
		
	}
	
	public void selectGlobalSettings(String globalsettings) throws InterruptedException
	{
		if(globalsettings.equalsIgnoreCase("Yes"))
		{
			GlobalYesRadioButton.click();
			Thread.sleep(1000);
		}
		else if(globalsettings.equalsIgnoreCase("No"))
		{
			GlobalNoRadioButton.click();
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("Global Settings not available");
		}
	}
	
	public void selectRequestFormType(String requestformType) throws InterruptedException
	{
		if(requestformType.equalsIgnoreCase("Default"))
		{
			RequestDefaultTypeRadioButton.click();
			Thread.sleep(1000);
		}
		else if(requestformType.equalsIgnoreCase("Custom"))
		{
			RequestCustomTypeRadioButton.click();
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("Request Form Type not available");
		}
	}
	
	public void selectMandatory(String mandatoryfields) throws InterruptedException
	{
		if(mandatoryfields.equalsIgnoreCase("Yes"))
		{
			MandatoryYesRadioButton.click();
			Thread.sleep(1000);
		}
		else if(mandatoryfields.equalsIgnoreCase("No"))
		{
			MandatoryNoRadioButton.click();
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("Mandatory fields not available");
		}
	}
	
	public void selectReviewers(String reviewers) throws InterruptedException
	{
		if(reviewers.equalsIgnoreCase("Requesters Choice"))
		{
			ReviewRequestUserRadioButton.click();
			Thread.sleep(1000);
		}
		else if(reviewers.equalsIgnoreCase("Direct Leader"))
		{
			DirectLeaderRadioButton.click();
			Thread.sleep(1000);
			
		}
		else if(reviewers.equalsIgnoreCase("Leaders"))
		{
			LeadersRadioButton.click();
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("Reviewers not available");
		}
	}
	
	public void selectAutomCompleteSettings(String autocomplete) throws InterruptedException
	{
		if(autocomplete.equalsIgnoreCase("Yes"))
		{
			AutomCompleteYesButton.click();
			Thread.sleep(1000);
		}
		else if(autocomplete.equalsIgnoreCase("No"))
		{
			AutomCompleteNoButton.click();
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("Auto Complete settings not available");
		}
	}
	
	public void selectCommentSettings(String commentssettings) throws InterruptedException
	{
		if(commentssettings.equalsIgnoreCase("Yes"))
		{
			ApproveWithCommentYesButton.click();
			Thread.sleep(1000);
		}
		else if(commentssettings.equalsIgnoreCase("No"))
		{
			ApproveWithCommentNoButton.click();
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("Comment settings not available");
		}
	}
	
	public void selectRequireByFieldSettings(String requirebyfield) throws InterruptedException
	{
		if(requirebyfield.equalsIgnoreCase("Yes"))
		{
			RequiredByFieldYesRadioButton.click();
			Thread.sleep(1000);
		}
		else if(requirebyfield.equalsIgnoreCase("No"))
		{
			RequiredByFieldNoRadioButton.click();
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("Require by field not available");
		}
	}
	
	public void selectCommentOptionSettings(String emptycommentsoption) throws InterruptedException
	{
		if(emptycommentsoption.equalsIgnoreCase("Yes"))
		{
			CommentYesButton.click();
			Thread.sleep(1000);
		}
		else if(emptycommentsoption.equalsIgnoreCase("No"))
		{
			CommentNoButton.click();
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("Empty Comment Option not available");
		}
		
	}
	
	
	public void selectCommentFieldTypeSettings(String commentsfieldtype) throws InterruptedException
	{
		if(commentsfieldtype.equalsIgnoreCase("Basic"))
		{
			CommentsFieldTypeBasicRadioButton.click();
			Thread.sleep(1000);
		}
		else if(commentsfieldtype.equalsIgnoreCase("Rich"))
		{
			
		}
		else
		{
			System.out.println("Comment Field Type not available");
		}
	}
	
	public void selectUserNotificationSettings(String usernotifications) throws InterruptedException
	{
		if(usernotifications.equalsIgnoreCase("All"))
		{
			UserNotificationAllRadioButton.click();
			Thread.sleep(1000);
		}
		else if(usernotifications.equalsIgnoreCase("Select"))
		{
			UserNotificationSelectRadioButton.click();
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("User Notification not available");
		}
		
	}
	
	public void clickSaveButton() throws InterruptedException
	{
		SaveButton.click();
		Thread.sleep(1000);
	}
	

}
