package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage extends Page{
	
   public BasePage(WebDriver driver) {
		super(driver);
		
	}
	
	@Override
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	@Override
	public String getTitle() {

		return driver.getTitle();
	}

	@Override
	public void waitFortTheElementPresent(By locator) {
		
		
	}

	
	

}
