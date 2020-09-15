package ResubaleUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Webactions implements Actionss {
	WebDriver driver;

	public void click(WebElement element) {
		element.click();
	}

	public void clickJSasFallBack(String locator) {
		WebElement ele=locate(locator);
	}

	

	public void jsClick(WebElement ele) {
		// TODO Auto-generated method stub
		
	}

	public void jsClick(String locator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jsClick() {
		// TODO Auto-generated method stub
		
	}
      
	
}
