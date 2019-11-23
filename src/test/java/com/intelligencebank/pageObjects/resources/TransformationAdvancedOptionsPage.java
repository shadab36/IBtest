package com.intelligencebank.pageObjects.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class TransformationAdvancedOptionsPage extends ResourcesBasePage {
	@FindBy(xpath= "//span[text()='menu']")
	WebElement Menuicon;

	@FindBy(xpath="//input[@placeholder='Search folder(s)']")
	WebElement SearchFolder;

	@FindBy(xpath="//span[text()='Prajakta Test folder']")
	WebElement MatchedFolder;

	@FindBy(xpath= "//div[@class='_checkboxThumb_121b3hn']")
	WebElement Select_multiplefile;

	@FindBy(xpath= "//div[@class='Select-control']")
	WebElement BulkApplyOption;

	@FindBy(xpath = "//span[contains(text(),'Transformation')]//ancestor::button")
	WebElement Transformation;

	@FindBy(xpath= "//span[text()='Add Preset']")
	WebElement AddPreset;

	@FindBy(xpath = "//span[text()='Advanced']/parent::div//following::div//input[@type='checkbox']")
	WebElement Advance_toggle;

	@FindBy(xpath= "//span[text()='Color Space']")
	WebElement ColorSpace;

	@FindBy(xpath= "//span[text()='Rotate']")
	WebElement RotateFiled;

	@FindBy(xpath= "//span[text()='Flip']")
	WebElement FlipField;

	public TransformationAdvancedOptionsPage(WebDriver driver) {
		super(driver);

	}

	public void searchFoldername(String Folder) throws InterruptedException {
		waitAndClick(ResourceMenuLink, 10);
		switchToIframe(resourcesIframe);
		waitAndClick(Menuicon, 10);
		waitAndClick(SearchFolder, 10);
		SearchFolder.sendKeys(Folder);
		SearchFolder.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement folder = driver.findElement(By.xpath("//span[text()='" + Folder + "']"));
		waitAndClick(folder, 10);
		}
	public void SelectMultiFolder() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			WebElement webelement = driver.findElement(By.xpath("(//div[@class='_checkboxThumb_121b3hn'])[" + i + "]"));
			webelement.click();
			Thread.sleep(1000);
		}}
	public void SelectDownlod() throws InterruptedException{
		waitAndClick(BulkApplyOption, 10);
		new Actions(driver).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
	}
	public void clickTransformation() throws InterruptedException {
		JavascriptExecutor jsw = (JavascriptExecutor) driver;
		jsw.executeScript("document.body.style.zoom='90%';");
		jsw.executeScript("arguments[0].click()", Transformation);
		Thread.sleep(2000);
	}
	public void clickAddPreset() throws InterruptedException {
//		js.executeScript("arguments[0].click()", AddPreset);
		Thread.sleep(2000);
	}
	public void Enable_AdvanceOption(String option) throws InterruptedException {
		switch (option) {
		case "ON":
			waitAndClick(Advance_toggle, 10);
			Thread.sleep(1000);
			break;
		case "OFF":
			break;
		}}
	public void verify_AdvanceFiled(String Color, String Rotate, String Flip) throws InterruptedException {
		if (ColorSpace.isEnabled()) {
			// JavaScriptHelper.scrollIntoView(ColorSpace);
			Thread.sleep(2000);
			String colorFiled = ColorSpace.getText();
			System.out.println(colorFiled);
			Thread.sleep(2000);
			String Rotatetext = RotateFiled.getText();
			System.out.println(Rotatetext);
			Thread.sleep(1000);
			String fliptext = FlipField.getText();
			System.out.println(fliptext);
			Thread.sleep(1000);
		}}
	public void Default_AdvanceOption(String ar1, String arg2, String arg3) throws InterruptedException {
		try {
//			JavaScriptHelper.scrollIntoView(ColorSpace);
			String colorFiled = ColorSpace.getText();
			System.out.println(colorFiled);
			String Rotatetext = RotateFiled.getText();
			System.out.println(Rotatetext);
			Thread.sleep(1000);
			String fliptext = FlipField.getText();
			System.out.println(fliptext);
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {
		}}}
