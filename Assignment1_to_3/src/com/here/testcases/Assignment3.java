package com.here.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.here.base.basePage;
import com.here.pages.actions.electronicsPage;
import com.here.pages.actions.flipkartHomePage;
import com.here.pages.actions.miPage;
import com.here.base.Constants;


public class Assignment3 extends basePage{
	
	public flipkartHomePage fp;

	
	@Test(groups= {"Sanity"},priority=1)
	public void navigateTo() throws InterruptedException {
		basePage.initializeBrowser();
		driver.get(Constants.flipkartURL);
		
		fp = new flipkartHomePage();
		fp.closeLoginModal();
		fp.clickOnElectronics();
		
	
		electronicsPage ec = new electronicsPage();
		ec.hoverOnMiLink();
		
		miPage mi = new miPage();
		Assert.assertFalse(mi.verifySearchLabel(Constants.verifyLabel));
		mi.slider();
		mi.thirdElementfromDropDown();
		basePage.quitBrowser();
			
	}
	
	@Test(groups= {"Regression"},priority=0)
	public void verifyOperations() throws InterruptedException {
		basePage.initializeBrowser();
		driver.get(Constants.flipkartURL);
		fp = new flipkartHomePage();
		fp.closeLoginModal();
		fp.searchForProduct();

		miPage mi = new miPage();
		mi.clickOnFirstLink();
		mi.switchToChildWindow();	
		Assert.assertTrue(mi.getProductAmount(1));
		mi.locateAndSwitchToFrame();
//		mi.enterPincode();
//		mi.clickOnViewDetails();
//		mi.ClickOnAddToCart();
		basePage.quitBrowser();
	}
	
	

}
