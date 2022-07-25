import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Movie {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;

	@Test
	public void verifyMovieInformation() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "\\src\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.allmovie.com");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("The Godfather");
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		System.out.println(driver.findElement(By.xpath("//div[@class='results']/h1")).getText());

		List<WebElement> theMovies = driver.findElements(By.xpath("//ul[@class='search-results']/li/div[2]/div[1]/a"));

		for (int i = 0; i < theMovies.size(); i++) {
			String extractedMovies = theMovies.get(i).getText();
			System.out.println(extractedMovies);
			if (extractedMovies.equalsIgnoreCase("The Godfather")) {
				theMovies.get(i).click();
				break;
			}
		}

		Assert.assertTrue(verifyMovieGenre("Crime"));

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,450)");

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mpaa']/div")));

		Assert.assertFalse(verifyMovieRating("A"));

		driver.findElement(By.xpath("//a[@title='Cast & Crew']")).click();

		Assert.assertTrue(verifyDirectorName("Francis Ford Coppola"));

		js.executeScript("window.scrollTo(0,300)");

		Assert.assertEquals("","Michael Corleone");

		Thread.sleep(5000);
		driver.close();

		// link - //ul[@class='search-results']/li/div[2]/div[1]/a
		// genre - //div[@class='details']/span[1]
		// verify - //section[@class='basic-info']/div/preceding-sibling::div
		// cast - //a[@title='Cast & Crew']
		// text - //dt[@class='name artist-name']//a[contains(text(),'Francis Ford
		// Coppola')]
		// cast - //div[@class='cast_name artist-name']/a
	}

//	List<WebElement> castName = driver.findElements(By.xpath("//div[@class='cast_container']/div[2]"));

	private boolean verifyActorName(String actorName) {
		// TODO Auto-generated method stub
		List<WebElement> realName = driver.findElements(By.xpath("//div[@class='cast_container']/div[2]"));
		for (int i = 0; i < realName.size(); i++) {
			System.out.println(realName.get(i).getText());
			String castName = realName.get(i).findElement(By.xpath("following-sibling::div")).getText();
			System.out.println(castName);
			if (castName.contains(actorName)) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean verifyDirectorName(String directorName) {
		// TODO Auto-generated method stub
		String tx = driver
				.findElement(By.xpath("//dt[@class='name artist-name']//a[contains(text(),'Francis Ford Coppola')]")).getText();
		if (tx.contains(directorName)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean verifyMovieRating(String rating) {
		// TODO Auto-generated method stub
		String tx = driver.findElement(By.xpath("//div[@class='mpaa']/div")).getText();
		if (tx.contains(rating)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean verifyMovieGenre(String genre) {
		// TODO Auto-generated method stub
		String tx = driver.findElement(By.xpath("//div[@class='details']/span[1]")).getText();
		if (tx.contains(genre)) {
			return true;
		} else {
			return false;
		}
	}

}
