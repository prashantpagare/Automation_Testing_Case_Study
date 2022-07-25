package com.here.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.here.base.basePage;
import com.here.pages.locators.googleSearchPageLocators;
import com.here.pages.locators.MovieHomePageLocators;

public class MovieHomePage extends basePage{

	public MovieHomePageLocators movie;
	
	public MovieHomePage() {
		this.movie = new MovieHomePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.movie);	
	}
	
	public MovieHomePage searchForMovie() {
		movie.searchMovie.sendKeys("The Godfather");
		return this;
	}

	public MovieHomePage clickOnSearch() {
		movie.sumitBtn.click();;
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
