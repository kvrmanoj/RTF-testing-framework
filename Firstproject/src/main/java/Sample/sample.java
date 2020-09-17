package Sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {

	public static void main(String[] args) throws InterruptedException, AWTException, ParseException {
		// TODO Auto-generated method stub
		WebDriver driver;
		String path=System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", path+"//chromedriver");

        driver = new ChromeDriver();

         driver.get("https://www.spicejet.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(200);
        if(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTX"))!=null)
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("Delhi");
        Thread.sleep(5000);
        driver.close();

        Thread.sleep(900);
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).sendKeys("Hydrabad");
        
        
        Thread.sleep(6000);
        
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr[3]/td[1]")).click();
        
      
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        
        Thread.sleep(7000);
        
        List<WebElement> list=driver.findElements(By.xpath("//table[@id='availabilityTable0']/tbody/tr/td/span[@class='travel-duration']"));
      //table[@id='availabilityTable0']/tbody/tr/td/span[text()="2h 25m"]
        List<WebElement> cost=driver.findElements(By.xpath("//table[@id='availabilityTable0']/tbody/tr/td[3]/p"));
        String largest=list.get(0).getText();
        String lowestcost=cost.get(0).getText();
    	int row=1;
        for(int i=0;i<list.size()-1;i++) {
        	String secondelement=list.get(i+1).getText();
        	String tr=largest;
        	
        	largest=getTimeFormat(largest,secondelement);
        	if(!tr.equalsIgnoreCase(largest)) row=row+1;
        }
        System.out.println(largest);
        System.out.println("Row:"+row);
        row=row+3;
        Thread.sleep(5000);
        driver.findElement(By.xpath("//table[@id='availabilityTable0']/tbody/tr["+row+"]/td[3]/p")).click();
	}

	public static String getTimeFormat(String str,String strr) throws ParseException {
		
	    Date time, time2;
		DateFormat dateFormat = new SimpleDateFormat("hh:mm");
		time=dateFormat.parse(getInTimeFormat(str));
		time2=dateFormat.parse(getInTimeFormat(strr));
		if(time.compareTo(time2)<0) 
		  return str;
		else return strr;
	 
	}
	public static String getInTimeFormat(String str) {
		String str1, str2;
	    str1=str.substring(0,str.indexOf('h'));
	    str2=str.substring(str.indexOf('h')+2,str.indexOf('m'));
	    str1=str1+":"+str2;
	    return str1;
	}
}



