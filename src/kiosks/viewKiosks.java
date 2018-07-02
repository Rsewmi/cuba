package kiosks;

//import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.driverDetails;


@Test 
public class viewKiosks extends driverDetails{
//	public int row_count;
	
  public void viewKiosk() {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath("//*[@id='app']/div[4]/aside/div[1]/div[3]/a/div[2]/div")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  System.out.println("Navigate to Kiosks Successfull");
	  
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 10);
	  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//I[@aria-hidden='true'][text()='arrow_drop_down'][text()='arrow_drop_down'])[5]")));
	  
	  driver.findElement(By.xpath("(//I[@aria-hidden='true'][text()='arrow_drop_down'][text()='arrow_drop_down'])[5]")).click();
	  
	  WebDriverWait wait2 = new WebDriverWait(driver, 10);
	  wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//DIV[@class='list__tile__title'][text()='All']")));
	  
	  driver.findElement(By.xpath("//DIV[@class='list__tile__title'][text()='All']")).click();
	  
	  System.out.println("View all kiosks successfull");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
  }

  
}






