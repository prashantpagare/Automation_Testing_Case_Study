package com.here.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class movieDetailsVerificationLocator {
	
	@FindBy(xpath="//div[@class='mpaa']/div\"")
	public WebElement mpaaRating;
	
	@FindBy(xpath="//a[@title='Cast & Crew']")
	public WebElement cast;
	
	
}
