import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class flipkart {
	public static WebDriver driver;
	public static String screenshotName;
	public static WebDriverWait wait;

	@Test
	public void performActions() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		
		driver.findElement(By.xpath("//img[@alt='Electronics']")).click();
	
		
		Actions action = new Actions(driver);
		WebElement electronics = driver.findElement(By.xpath("//span[text()='Electronics']"));
		action.moveToElement(electronics).build().perform();
		
//		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Mi']")));
		
		WebElement miLink = driver.findElement(By.xpath("//a[@title='Mi']"));
		action.moveToElement(miLink).click().build().perform();
		
		Assert.assertFalse(verifySearchLabel("Latest from MI"));
		Thread.sleep(1000);
		
		WebElement slider = driver.findElement(By.xpath("//section[@class='_2yz7eI _2hbLCH']/div[3]/div"));
//		WebElement source = driver.findElement(By.xpath("//div[@class='_31Kbhn _28DFQy']//div[@class='_3FdLqY']"));
//		WebElement destination = driver.findElement(By.xpath("//div[@class='_31Kbhn WC_zGJ']//div[@class='_3FdLqY']"));
		action.dragAndDropBy(slider, 0, 250).build().perform();
//		action.dragAndDrop(source, destination).build().perform();
		
//		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_3uDYxP']")));
//		
		Select dropdown = new Select(driver.findElement(By.xpath("//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")));
		dropdown.selectByIndex(2);
		Thread.sleep(5000);
		driver.close();
}
	
	
	//@Test
	public void search() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("redmi go (black, 8 gb)");
		driver.findElement(By.xpath("//button[@type='submit']//*[name()='svg']")).click();
		
		List<WebElement> smartphones = driver.findElements(By.xpath("//div[@class='col col-7-12']/div[1]"));
		
		for(int i=0;i<smartphones.size();i++) {
			String mobText = smartphones.get(i).getText();
			if(mobText.contains("8 GB")) {
				smartphones.get(i).click();
			}		
		}
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> id = ids.iterator();
		String parent = id.next();
		String child = id.next();
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());
		
//		Assert.assertEquals(getProductAmount(), 1234);
//		Assert.assertTrue(getProductAmount(), 0);
		System.out.println(driver.getPageSource().contains("iframe"));
//		WebElement frame = driver.findElement(By.xpath("//div[@class='_1AuMiq P9aMAP']//div[@class='_2E1FGS']"));
		driver.switchTo().frame("_2mLllQ");
//		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//div[@class='_2usHgU']")).click();
	}

	private boolean getProductAmount() {
		int amount = 0;
		String text = driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText();
		String arr = text.replace("₹", "").replace(",", "");
		int actAmount = Integer.parseInt(arr);
		if(actAmount >= amount) {
			amount += actAmount;
			return true;
		}else {
			return false;
		}
	}


	private boolean verifySearchLabel(String label) {
		// TODO Auto-generated method stub
		String result = driver.findElement(By.xpath("//span[@class='_2tDckM']")).getText();
		System.out.println(result);
		if(result.contains(label)) {
			return true;
		} else {
			return false;
		}
	}
}