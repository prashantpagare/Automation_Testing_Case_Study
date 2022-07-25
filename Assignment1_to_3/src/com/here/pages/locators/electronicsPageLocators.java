package com.here.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class electronicsPageLocators {

	@FindBy(xpath="//span[text()='Electronics']")
	public WebElement electronicsLink;
	
	@FindBy(xpath="//a[@title='Mi']")
	public WebElement miLinkz;
	
	
}
