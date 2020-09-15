package functionalLibrary;

import java.security.DrbgParameters.Capability;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import ResubaleUtility.Const;
import ResubaleUtility.PropertyManager;

public class DesiredCapablity {
	
	@SuppressWarnings("unchecked")
	protected DesiredCapabilities getChromeOptions( ) {
		
		DesiredCapabilities caps=DesiredCapabilities.chrome();
		ChromeOptions options=new ChromeOptions();
	
	    Map<String,Object> chromePref= PropertyManager.getPropertyByPrefix(Const.CHROME_PREF);
	    options.setExperimentalOption("prefs", chromePref);
	
	    Map<String, Object>  getExpertimentalOptions=PropertyManager.getPropertyByPrefix(Const.CHROME_ARGUMENTS);
	    for(String Option:getExpertimentalOptions.keySet()) {
	    	options.setExperimentalOption(Option, getExpertimentalOptions.get(Option).toString());
	    }
	    	
		
	    options.addArguments(PropertyManager.getArray(Const.CHROME_ARGUMENTS, "+"));
	    caps.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(caps);
		return caps;
		}
		

    protected DesiredCapabilities getFirefoxCap( ) {
		
		DesiredCapabilities caps;
		caps=DesiredCapabilities.firefox();
		FirefoxProfile p=new FirefoxProfile();
		Map<String,Object> firefoxpreference=PropertyManager.getPropertyByPrefix(Const.FIREFOX_PREF);
		if(firefoxpreference!=null&& firefoxpreference.size()>0) {
			for(String key:firefoxpreference.keySet())
				p.setPreference(key, firefoxpreference.get(key).toString());
		}
		caps.setCapability(FirefoxDriver.PROFILE, p);
		return caps;
	}

	
	protected DesiredCapabilities getCommonCaps() {
		DesiredCapabilities caps=null;
		HashMap<String, Object> commoncap=PropertyManager.getPropertyByPrefix(Const.CAPABILITY_PREFIX);
		for(String capname:commoncap.keySet()) {
			caps.setCapability(capname,commoncap.get(capname)); 
		}
		return caps;
	}
}

