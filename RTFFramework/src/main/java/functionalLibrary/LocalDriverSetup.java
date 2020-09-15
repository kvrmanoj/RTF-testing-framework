package functionalLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LocalDriverSetup extends DesiredCapablity implements Driver{

	DesiredCapabilities caps;
	@Override
	public DesiredCapabilities getDriverCapability(Browser browser) {
		
		switch(browser){
		case Chrome:
			caps=getChromeOptions();
			break;
		case Firefox:
			caps=getFirefoxCap();
			break;
		case Edge:		
			caps=DesiredCapabilities.edge();
			break;
		case InternerExplorer:
			caps=DesiredCapabilities.internetExplorer();
			break;
		case Safari:
			caps=DesiredCapabilities.safari();
			break;
	
		}
		caps=getCommonCaps();
		return caps;
	}

	@Override
	public WebDriver getDriver(Browser browser) {
	     WebDriver driver=null;   
	    
	    
		switch(browser){
		case Chrome:
			ChromeOptions options=new ChromeOptions();
			driver=new ChromeDriver(caps);
			break;
		case Firefox:
			caps=getFirefoxCap();
			break;
		case Edge:		
			caps=DesiredCapabilities.edge();
			break;
		case InternerExplorer:
			caps=DesiredCapabilities.internetExplorer();
			break;
		case Safari:
			caps=DesiredCapabilities.safari();
			break;
	
		}
		return driver;
		
	}
	
}
