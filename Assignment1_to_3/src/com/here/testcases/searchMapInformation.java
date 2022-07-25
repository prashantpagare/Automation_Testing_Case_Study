package com.here.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.here.base.Constants;
import com.here.base.basePage;
import com.here.pages.actions.googleSearchPage;

public class searchMapInformation extends basePage{

	
	@Test
	public void searchingLocation() throws IOException {
		
		basePage.initializeBrowser();
		driver.get(Constants.googleSiteURL);
		googleSearchPage gs = new googleSearchPage();
		gs.searchForItem(Constants.location);
		gs.clickOnsearch();			
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(Constants.elementVerify)));	
//		wait.until(ExpectedConditions
//				.visibilityOfElementLocated(gs.verifyTextOnPage()));		
		captureScreenshot();
		Assert.assertTrue(gs.isTextPresent(Constants.location));
		Assert.assertEquals(driver.getTitle(), Constants.getTitle);
		gs.printReview();
		gs.printRating();
		Assert.assertTrue(gs.isLinkPresent(Constants.actualLink));
		gs.printAddress();
		Assert.assertTrue(gs.isPhoneNumberPresent(Constants.phoneNum));
		captureScreenshot();
		basePage.quitBrowser();
		
	}
}
