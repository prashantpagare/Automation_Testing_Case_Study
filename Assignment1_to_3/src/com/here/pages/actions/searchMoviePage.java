package com.here.pages.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.here.base.basePage;
import com.here.pages.locators.MovieHomePageLocators;
import com.here.pages.locators.searchMoviePageLocator;

public class searchMoviePage extends basePage{
	
	public searchMoviePageLocator search;
	
	public searchMoviePage() {
		this.search = new searchMoviePageLocator();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.search);	
	}
	
	public searchMoviePage getMoviesCount() {
		String movies = search.movieCount.getText();
		System.out.println(movies);
		return this;
	}

	public searchMoviePage clickOnDesiredMovie() {
		List<WebElement> theMovies = search.allMovies;

		for (int i = 0; i < theMovies.size(); i++) {
			String extractedMovies = theMovies.get(i).getText();
			System.out.println(extractedMovies);
			if (extractedMovies.equalsIgnoreCase("The Godfather")) {
				theMovies.get(i).click();
				break;
			}
		}
		return this;
	}
	
}
