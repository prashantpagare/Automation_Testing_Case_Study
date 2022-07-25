package com.here.pages.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.here.base.basePage;
import com.here.pages.locators.CastAndCrewPageLocators;
import com.here.pages.locators.movieDetailsVerificationLocator;

public class CastAndCrewPage extends basePage {
	
	public CastAndCrewPageLocators cast;

	public CastAndCrewPage() {
		this.cast = new CastAndCrewPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.cast);	
	}
	
	public boolean verifyDirectorName(String directorName) {
		// TODO Auto-generated method stub
		String tx = driver
				.findElement(By.xpath("//dt[@class='name artist-name']//a[contains(text(),'Francis Ford Coppola')]")).getText();
		if (tx.contains(directorName)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyActorName() {
		String actName = driver.findElement(By.xpath("//div[normalize-space()='Michael Corleone']")).getText();
		String expName = "Michael Corleone";
		if(actName.equalsIgnoreCase(expName)) {
			return true;
		}else {
			return false;
		}
	}
	
}
