package driver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class driverDetails {
	
	//Globally used variables 
	public static WebDriver driver;
	String baseUrl = "http://slt-kiosk.thinkcube.net/#/";
	int intValue = driverDetails.randomNumber();
	protected String stringValue = Integer.toString(intValue);
	

	public int rows_count;
	
	
	
	@BeforeSuite
	public void drivers(){
	System.setProperty("webdriver.chrome.driver", "/home/thinkcube/workspace/chromedriver/chromedriver");
    driver = new ChromeDriver();
	String baseUrl = "http://slt-kiosk.thinkcube.net/#/";
	driver.get(baseUrl);
	System.out.println("Driver initiative successful");
	
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	

	
	}
	//get the random number for all input details
	@Test
	public static int randomNumber(){
		Random rand = new Random(); 
		int value = rand.nextInt(90000000);
		return value;
	}

}
