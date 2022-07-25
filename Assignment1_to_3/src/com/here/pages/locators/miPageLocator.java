package com.here.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class miPageLocator {


	@FindBy(xpath="//div[@class='_12FhcQ']")
	public WebElement slider;
	
	@FindBy(xpath="//span[text()='Electronics']")
	public WebElement electronicsLink;
	
	@FindBy(xpath="//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")
	public WebElement drpdown;
	
	@FindBy(xpath="//input[@id='pincodeInputId']")
	public WebElement pincode;
	
	@FindBy(xpath="//span[@class='YxlyDn']")
	public WebElement viewDetails;
	
	@FindBy(xpath="//div[@class='_2_e-g9']/button")
	public WebElement deliveryDetailsModal;
	
	@FindBy(xpath="//li[@class='col col-6-12']/button")
	public WebElement addToCart;
	
	//ul[@class='_3GnUWp']/li[2]
	
	
}
