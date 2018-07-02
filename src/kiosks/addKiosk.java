package kiosks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import driver.driverDetails;

public class addKiosk extends driverDetails {
	public int row_count;
  @BeforeClass
  public void openModal() {
	  
	  driver.findElement(By.xpath("(//DIV[@class='btn__content'])[11]")).click();  
  }
  
  @Test
  public void sendKeysColombo() throws InterruptedException {
	  driver.findElement(By.xpath("(//INPUT[@required='required'])[3]")).sendKeys(stringValue);
	  driver.findElement(By.xpath("(//INPUT[@required='required'])[4]")).sendKeys(stringValue);
	  driver.findElement(By.xpath("(//I[@aria-hidden='true'][text()='arrow_drop_down'][text()='arrow_drop_down'])[4]")).click();
	  driver.findElement(By.xpath("(//DIV[@class='list__tile__title'][text()='Colombo'][text()='Colombo'])[2]")).click();
	  driver.findElement(By.xpath("(//DIV[@class='btn__content'][text()='Save'][text()='Save'])[2]")).click();
	  
	  driver.navigate().refresh();
	  
	  // listdown all kiosks
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 10);
	  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//I[@aria-hidden='true'][text()='arrow_drop_down'][text()='arrow_drop_down'])[5]")));
	  
	  driver.findElement(By.xpath("(//I[@aria-hidden='true'][text()='arrow_drop_down'][text()='arrow_drop_down'])[5]")).click();
	  
	  WebDriverWait wait2 = new WebDriverWait(driver, 10);
	  wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//DIV[@class='list__tile__title'][text()='All']")));
	  
	  driver.findElement(By.xpath("//DIV[@class='list__tile__title'][text()='All']")).click();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  //System.out.println("add kiosks random number :"+stringValue);
	  
	  
  }
  
  // get the number of kiosks
  @AfterMethod
  public static int row_number(){
	 
	List<WebElement> rows_table = driver.findElements(By.cssSelector("[class='datatable table'] tbody tr"));
	//To calculate no of rows In table.
	int rows_count = rows_table.size();
	return rows_count;
	  
  }
  // just a print of number of kiosks
  @AfterClass
  public static void printRows(){
	  int row_count = addKiosk.row_number();
	  System.out.println("Total number of kiosks :" + row_count);
  }
  

  
}
