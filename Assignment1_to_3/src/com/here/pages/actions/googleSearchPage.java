package com.here.pages.actions;


import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.here.base.basePage;
import com.here.pages.locators.googleSearchPageLocators;

import bsh.org.objectweb.asm.Constants;

public class googleSearchPage extends basePage{
	
	public googleSearchPageLocators search;
	
	public googleSearchPage() {
		this.search = new googleSearchPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.search);	
	}

	public googleSearchPage searchForItem(String location) {
		search.searchInput.sendKeys(location);
		return this;
	}
	
	public googleSearchPage clickOnsearch() {
		search.clickBtn.click();
		return this;
	}
	
	public googleSearchPage verifyTextOnPage() {
		String text = search.elementToVerify.getText();
		return this;
	}
	
	public String printReview() {
		String text = search.reviews.getText();
		System.out.println(text);
		return text;
	}
	
	public String printRating() {
		String text = search.rating.getText();
		System.out.println(text);
		return text;
	}
	
	public String printAddress() {
		String text = search.address.getText();
		System.out.println(text);
		return text;
	}
	
	public boolean isLinkPresent(String link) {
		// TODO Auto-generated method stub
		String extractedLink = driver.findElement(By.xpath("//div[@class='rogA2c ITvuef']/child::div[1]")).getText();
		if (extractedLink.equals(link)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isPhoneNumberPresent(String phNum) {
		// TODO Auto-generated method stub
		String phnText = driver.findElement(By.xpath("//div[contains(text(),'022 2279 5500')]")).getText();
		if (phnText.equals(phNum)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isTextPresent(String text) {
		// TODO Auto-generated method stub
		String iniText = driver.findElement(By.xpath("//input[@id='searchboxinput']")).getAttribute("value");
		if (iniText.contains(text)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getTitle() {
		String text = search.getTitle.getText();
		System.out.println(text);
		return text;
	}
	
}
