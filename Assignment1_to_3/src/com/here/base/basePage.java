package com.here.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.here.base.Constants;



public class basePage {
	
	public static WebDriver driver;
	public static String browser;
	public static WebDriverWait wait;
	public static String screenshotName;
	public static JavascriptExecutor js;
	
	
	public static void initializeBrowser() {
		if(Constants.browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");	
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disabled-extensions");
			options.addArguments("--disabled-infobars");
			driver = new ChromeDriver(options);
		}else if(Constants.browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(Constants.browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\drivers\\IEDriverServer.exe");
			driver = new FirefoxDriver();
	}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(Constants.implicit_wait)));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

}
	
	public static void captureScreenshot() throws IOException {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\src\\screenshots\\" + screenshotName));
	}

	
	public static void quitBrowser() {
		driver.quit();
	}
}
