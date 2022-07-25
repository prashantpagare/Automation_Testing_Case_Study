import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Maps {

	public static WebDriver driver;
	public static String screenshotName;
	public static WebDriverWait wait;

	@Test
	public void search() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/maps");
		driver.findElement(By.xpath("//input[@id='searchboxinput']")).sendKeys("Wankhede Stadium");
		driver.findElement(By.xpath("//button[@id='searchbox-searchbutton']")).click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Attractions']")));

		captureScreenshot();

		Assert.assertTrue(isTextPresent("Stadium"));
		Assert.assertEquals(driver.getTitle(), "Wankhede Stadium - Google Maps");
		System.out.println(driver.findElement(By.xpath("//div[@class='LBgpqf']/div/div[1]/span")).getText());
		System.out.println(driver
				.findElement(By.xpath(
						"//div[contains(@jsan,'t-dgE5uNmzjiE,7.m6QErb,0.aria-label')]/div[3]/button/div[1]/div[2]"))
				.getText());
		System.out.println(
				driver.findElement(By.xpath("//div[@class='LBgpqf']/div/div[1]/div[2]/span/span/span[1]")).getText());
		Assert.assertTrue(isPhoneNumberPresent("022 2279 5500"));
		Assert.assertTrue(isLinkPresent("mumbaicricket.com"));

		captureScreenshot();
		driver.close();
	}

	private boolean isLinkPresent(String link) {
		// TODO Auto-generated method stub
		String extractedLink = driver.findElement(By.xpath("//div[@class='rogA2c ITvuef']/child::div[1]")).getText();
		if (extractedLink.equals(link)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isPhoneNumberPresent(String phNum) {
		// TODO Auto-generated method stub
		String phnText = driver.findElement(By.xpath("//div[contains(text(),'022 2279 5500')]")).getText();
		if (phnText.equals(phNum)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isTextPresent(String text) {
		// TODO Auto-generated method stub
		String iniText = driver.findElement(By.xpath("//input[@id='searchboxinput']")).getAttribute("value");
		if (iniText.contains(text)) {
			return true;
		} else {
			return false;
		}
	}

	public static void captureScreenshot() throws IOException {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\src\\screenshots\\" + screenshotName));
	}
}
