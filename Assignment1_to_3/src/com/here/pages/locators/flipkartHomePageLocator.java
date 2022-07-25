package com.here.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class flipkartHomePageLocator {
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	public WebElement closeLoginModal;
	
	@FindBy(xpath="//img[@alt='Electronics']")
	public WebElement electronics;
	
	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
	public WebElement searchbox;
	
	@FindBy(xpath="//button[@type='submit']//*[name()='svg']")
	public WebElement clicksearchIcon;
	
	
	

}
