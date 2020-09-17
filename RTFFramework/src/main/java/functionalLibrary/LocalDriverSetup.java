package functionalLibrary;

import java.util.InputMismatchException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

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

	@SuppressWarnings("deprecation")
	@Override
	public WebDriver getDriver(Browser browser) {
	     WebDriver driver=null;   
	     
	    
		switch(browser){
		case Chrome:
			String path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path+"//chromedriver");			
			ChromeOptions options=new ChromeOptions();
			options.merge(caps);
			driver=new ChromeDriver(options);
			break;
		case Firefox:
			FirefoxOptions p=new FirefoxOptions();
			p.merge(caps);
			driver=new FirefoxDriver(p);
		case Edge:	
			 driver=new EdgeDriver(caps);
			break;
		case InternerExplorer:
			driver=new InternetExplorerDriver();
			caps=DesiredCapabilities.internetExplorer();
			break;
		case Safari:
			driver=new SafariDriver();
			caps=DesiredCapabilities.safari();
			break;
		case IOS:
		    throw new InputMismatchException("IOS is not supoorted in local test execution ");
		case Andriod:
			throw new InputMismatchException("Andriod is not supoorted in local test execution ");
		}
		return driver;
		
	}
	
}
