package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	WebDriver driver;
	public Page(WebDriver driver)
	{
		this.driver=driver;
		WebDriverWait wait=new WebDriverWait(driver,15);
	}
	
    public abstract WebElement getElement(By locator);
    public abstract String getTitle();
    public abstract void waitFortTheElementPresent(By locator);
    public  <TPage extends BasePage> TPage getReference(Class<TPage> pageClass) throws Exception{
    	
    	return pageClass.getDeclaredConstructor().newInstance(this.driver);
    }
}
