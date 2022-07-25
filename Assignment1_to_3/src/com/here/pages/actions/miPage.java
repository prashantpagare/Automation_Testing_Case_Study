package com.here.pages.actions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.here.base.basePage;
import com.here.pages.locators.electronicsPageLocators;
import com.here.pages.locators.miPageLocator;

public class miPage extends basePage {

	public miPageLocator mi;
	Actions action = new Actions(driver);

	public miPage() {
		this.mi = new miPageLocator();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.mi);
	}

	public boolean verifySearchLabel(String label) {
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='_2tDckM']")));
		String result = driver.findElement(By.xpath("//span[@class='_2tDckM']")).getText();
		System.out.println(result);
		if(result.contains(label)) {
			return true;
		} else {
			return false;
		}
	}

	public miPage slider() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@class='_2yz7eI _2hbLCH']/div[3]/div")));
		WebElement sliders = driver.findElement(By.xpath("//section[@class='_2yz7eI _2hbLCH']/div[3]/div"));
		action.dragAndDropBy(sliders, 0, 250).build().perform();
		return this;
	}

	public miPage thirdElementfromDropDown() {
		Select dropdown = new Select(driver.findElement(By.xpath("//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")));
		dropdown.selectByIndex(2);
		return this;
	}

	public miPage clickOnFirstLink() {
List<WebElement> smartphones = driver.findElements(By.xpath("//div[@class='col col-7-12']/div[1]"));
		
		for(int i=0;i<smartphones.size();i++) {
			String mobText = smartphones.get(i).getText();
			if(mobText.contains("8 GB")) {
				smartphones.get(i).click();
			}		
		}
		return this;
	}
	
	public miPage switchToChildWindow() {
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> id = ids.iterator();
		String parent = id.next();
		String child = id.next();
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());
		return this;
	}
	
	public miPage switchToParentWindowWindow() {
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> id = ids.iterator();
		String parent = id.next();
		String child = id.next();
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
		return this;
	}
	
	
	public boolean getProductAmount(int actualValue) {
		String text = driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText();
		String arr = text.replace("₹", "").replace(",", "");
		int actAmount = Integer.parseInt(arr);
		if(actualValue >= 0 ) {
			return true;	
		}else {
			return false;
		}
	}
	
	public miPage locateAndSwitchToFrame() {
		WebElement frame = driver.findElement(By.xpath("//div[@class='_1AuMiq P9aMAP']//div[@class='_2E1FGS']"));
//		driver.switchTo().frame(1);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_3g-Cpg']")));
		driver.findElement(By.xpath("//div[@class='_3g-Cpg']")).click();
		return this;
	}
	
	public miPage enterPincode() {
		mi.pincode.clear();
		action.moveToElement(mi.pincode).click().sendKeys("410208").build().perform();
//		mi.pincode.sendKeys("410208");
		return this;
	}
	
	public miPage clickOnViewDetails() {
		mi.viewDetails.click();
		return this;
	}

	public miPage closeDetailsModal() {
		mi.deliveryDetailsModal.click();
		return this;
	}
	
	public miPage ClickOnAddToCart() {
		mi.addToCart.click();
		return this;
	}
	
}
