package com.here.pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.here.base.basePage;
import com.here.pages.locators.movieDetailsVerificationLocator;
import com.here.pages.locators.searchMoviePageLocator;

public class movieDetailsVerification extends basePage{
	
	
public movieDetailsVerificationLocator details;
	
	public movieDetailsVerification() {
		this.details = new movieDetailsVerificationLocator();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.details);	
	}

	public movieDetailsVerification scrollIntoView() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,450)");
		return this;
	}
	
	public movieDetailsVerification clickOnCastandCrewLink() {
		details.cast.click();
		return this;
	}
	
	public boolean verifyMovieGenre(String genre) {
		// TODO Auto-generated method stub
		String tx = driver.findElement(By.xpath("//div[@class='details']/span[1]")).getText();
		if (tx.contains(genre)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifyMovieRating(String rating) {
		// TODO Auto-generated method stub
		String tx = driver.findElement(By.xpath("//div[@class='mpaa']/div")).getText();
		if (tx.contains(rating)) {
			return true;
		} else {
			return false;
		}
	}
}
