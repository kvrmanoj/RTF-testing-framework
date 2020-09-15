package functionalLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface Driver {

	 DesiredCapabilities getDriverCapability(Browser browser);
	 WebDriver getDriver(Browser browser);	
}
