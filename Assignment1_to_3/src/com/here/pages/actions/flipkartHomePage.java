package com.here.pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.here.base.basePage;
import com.here.pages.locators.flipkartHomePageLocator;

public class flipkartHomePage extends basePage{
	
	public flipkartHomePageLocator flip;
	
	public flipkartHomePage(){
		this.flip = new flipkartHomePageLocator();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.flip);		
	}
	
	
	public flipkartHomePage closeLoginModal() {
		flip.closeLoginModal.click();
		return this;
	}


	public flipkartHomePage clickOnElectronics() {
		flip.electronics.click();
		return this;
	}
	
	public flipkartHomePage searchForProduct() {
		flip.searchbox.sendKeys("redmi go (black, 8 gb)");
		flip.searchbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public flipkartHomePage clickOnSearchIcon() {
		flip.electronics.click();
		return this;
	}

}
