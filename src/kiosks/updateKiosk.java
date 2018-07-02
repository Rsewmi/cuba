package kiosks;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import driver.driverDetails;
//import kiosks.viewKiosks;


public class updateKiosk extends driverDetails {
	public static int row_count;
	
  @BeforeClass
  public static void numberofKiosk(){
	  row_count = addKiosk.row_number();
	  System.out.println("Total number of kiosks uk : " + row_count);
	  
	  WebElement baseTable = driver.findElement(By.className("table__overflow"));
	  
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  WebElement cellInfo = baseTable.findElement(By.xpath("//table/tbody/tr["+row_count+"]/td[2]"));
	  String cellText = cellInfo.getText();
	  System.out.println("Added kiosk before update :" + cellText);
	  
	  
  } 

	  @Test
	  public void editKiosk() throws InterruptedException {

		  Thread.sleep(1000);
		  
		  //edit kiosk

		  driver.findElement(By.xpath("//*[@id='app']/div[11]/main/div/div/div/div[2]/div[1]/table/tbody/tr["+ row_count +"]/td[7]/button[1]/div")).click();
		  
		  System.out.println("open modal");
		  
		  WebElement addKeys = driver.findElement(By.xpath("(//INPUT[@required='required'])[1]"));
		  addKeys.sendKeys("1");
		  driver.findElement(By.xpath("//DIV[@class='btn__content'][text()='Update']")).click();
		  System.out.println("Added new value to update");
		  
	  }

	  @AfterClass
	  public void afterTest() throws InterruptedException{
		  Thread.sleep(3000);
		  
		  // get the name of updated kiosk
		  System.out.println("thread sleep");
		  WebElement baseTable = driver.findElement(By.className("table__overflow"));
		  
		  Thread.sleep(1000);
		  WebElement cellInfo = baseTable.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
		  String cellText = cellInfo.getText();
		  System.out.println("Added kiosk after update :" + cellText);
		  
		  //System.out.println("updatekiosks random number :"+stringValue);
		  
	  }
  
}
