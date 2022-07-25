package com.here.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MovieHomePageLocators {
	
	
	@FindBy(xpath="//input[@placeholder='Search']")
	public WebElement searchMovie;
	
	@FindBy(xpath="//input[@name='submit']")
	public WebElement sumitBtn;
	
}
