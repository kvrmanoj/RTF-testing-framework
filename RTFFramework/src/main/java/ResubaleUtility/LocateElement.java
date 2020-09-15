package ResubaleUtility;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocateElement {
	static WebDriver driver;
	
	public static WebElement locate(String locator) {
	
		
		List<By> locaters=List.of(By.className(locator),By.xpath(locator),By.cssSelector(locator),By.id(locator),By.name(locator),By.linkText(locator),By.partialLinkText(locator));
		for(By locater:locaters) {
			if(driver.findElement(locater) != null) {
				
			}
		}
		
		WebElement ele=driver.findElement(By.className(locator));
		return ele;
		
	}

}
