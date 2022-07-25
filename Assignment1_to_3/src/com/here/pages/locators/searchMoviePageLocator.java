package com.here.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchMoviePageLocator {
	
	@FindBy(xpath="//div[@class='results']/h1")
	public WebElement movieCount;
	
	@FindBy(xpath="//ul[@class='search-results']/li/div[2]/div[1]/a")
	public List<WebElement> allMovies;
	
	

}
