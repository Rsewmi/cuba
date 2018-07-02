package loginTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import driver.driverDetails;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


public class login extends driverDetails {
	
	//login credentials 
	
	@DataProvider(name = "Authentication")
	public static Object [][] credetials(){
		return new Object [][]{{"sewmir","123456"}, {"sewmi","12345678"}, {"abc","3333"},{"sewmir","12345678"}};
	  
	}
			

@Test(dataProvider = "Authentication")
  public void beforeSuite(String userName, String passwords) throws InterruptedException {
		
      WebElement email = driver.findElement(By.xpath("(//INPUT[@required='required'])[1]"));
      WebElement password = driver.findElement(By.xpath("(//INPUT[@required='required'])[2]"));
      WebElement login = driver.findElement(By.xpath("//DIV[@class='btn__content'][text()='Login']"));
      
      email.sendKeys(userName);
      password.sendKeys(passwords);
      login.click();
      
      driver.manage().window().maximize();
      
      //Thread.sleep(2000);
      driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
      
      
      WebElement menuHoverLink = null;
      try
      {
          menuHoverLink = driver.findElement(By.xpath("(//INPUT[@required='required'])[1]"));
      }
      catch(Exception e)
      {
    	  System.out.println("can't find the element");
      }
      if (menuHoverLink != null){
          WebElement toClear = driver.findElement(By.xpath("(//INPUT[@required='required'])[1]"));
          toClear.sendKeys(Keys.CONTROL + "a");
          toClear.sendKeys(Keys.DELETE);
          
          driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
          
          WebElement toClear1 = driver.findElement(By.xpath("(//INPUT[@required='required'])[2]"));
          toClear1.sendKeys(Keys.CONTROL + "a");
          toClear1.sendKeys(Keys.DELETE);
    	  
    	  
      }
      
      
      
      System.out.println("User login Pass");
//    System.out.println("driver 1 ="+driver);
      
  }
 


}
