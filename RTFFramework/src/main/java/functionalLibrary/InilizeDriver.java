package functionalLibrary;

import org.openqa.selenium.WebDriver;

public class InilizeDriver {
	
	WebDriver driver;
	 ThreadLocal<WebDriver> webdriver=new ThreadLocal<WebDriver>(); 
	 
	 private  InilizeDriver() {
		 
	 }
	 
	 

}
