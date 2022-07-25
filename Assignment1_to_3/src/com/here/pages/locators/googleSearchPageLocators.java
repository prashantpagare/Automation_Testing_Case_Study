package com.here.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class googleSearchPageLocators {
	
	@FindBy(xpath="//input[@id='searchboxinput']")
	public WebElement searchInput;

	@FindBy(xpath="//button[@id='searchbox-searchbutton']")
	public WebElement clickBtn;
	
	@FindBy(xpath="//span[text()='Attractions']")
	public WebElement elementToVerify;
	
	@FindBy(xpath="//div[@class='LBgpqf']/div/div[1]/span")
	public WebElement reviews;
	
	@FindBy(xpath="//div[@class='LBgpqf']/div/div[1]/div[2]/span/span/span[1]")
	public WebElement rating;
	
	@FindBy(xpath="//title[normalize-space()='Wankhede Stadium - Google Maps']")
	public WebElement getTitle;
	
	@FindBy(xpath="//div[contains(@jsan,'t-dgE5uNmzjiE,7.m6QErb,0.aria-label')]/div[3]/button/div[1]/div[2]")
	public WebElement address;
}
