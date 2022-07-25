package com.here.pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.here.base.basePage;
import com.here.pages.locators.electronicsPageLocators;
import com.here.pages.locators.flipkartHomePageLocator;

public class electronicsPage extends basePage{

	
public electronicsPageLocators electronics;

	public static Actions action;

	public electronicsPage(){
		this.electronics = new electronicsPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.electronics);		
	}
	
	public electronicsPage hoverOnMiLink() throws InterruptedException {
		action = new Actions(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Electronics']")));
		WebElement electronics = driver.findElement(By.xpath("//span[text()='Electronics']"));
		action.moveToElement(electronics).build().perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Mi']")));
		WebElement miLink = driver.findElement(By.xpath("//a[@title='Mi']"));
		action.moveToElement(miLink).click().build().perform();
		return this;
	}
	
		
}
