package com.here.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.here.base.Constants;
import com.here.base.basePage;
import com.here.pages.actions.CastAndCrewPage;
import com.here.pages.actions.MovieHomePage;
import com.here.pages.actions.movieDetailsVerification;
import com.here.pages.actions.searchMoviePage;

public class Assignment2 extends basePage{
	
	@Test
	public void movie() {
		
		basePage.initializeBrowser();
		driver.get(Constants.movieSiteURL);
		MovieHomePage mv = new MovieHomePage();
		mv.searchForMovie();
		mv.clickOnSearch();
		
		searchMoviePage sp = new searchMoviePage();
		sp.getMoviesCount();
		sp.clickOnDesiredMovie();
		
		movieDetailsVerification ver = new movieDetailsVerification();
		
		Assert.assertTrue(ver.verifyMovieGenre(Constants.genre));	
		ver.scrollIntoView();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.rating)));
		
		Assert.assertFalse(ver.verifyMovieRating(Constants.expectedRating));
		ver.clickOnCastandCrewLink();
		
		CastAndCrewPage crew = new CastAndCrewPage();
		
		Assert.assertTrue(crew.verifyDirectorName(Constants.directorName));
		ver.scrollIntoView();

		Assert.assertTrue(crew.verifyActorName(),"Michael Corleone");
		
		basePage.quitBrowser();
		
	}

}
