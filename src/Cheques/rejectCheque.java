package Cheques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class rejectCheque extends driver.driverDetails {
	
	public String beforeCellValue = null;
	public String afterCellValue = null;
	
  @Test
  public void rejectCheques() throws InterruptedException {
//	  navigate to the 1st cheque
	  driver.findElement(By.xpath("//table/tbody/tr[1]/td[8]")).click();
	  Thread.sleep(10000);
	  
//	  click invalid button
	  driver.findElement(By.xpath("//DIV[@class='btn__content'][text()='Invalid']")).click();
	  
	  driver.findElement(By.xpath("(//INPUT[@tabindex='0'])[1]")).sendKeys("Reason for invalid cheque");
	  driver.findElement(By.xpath("//DIV[@class='btn__content'][text()='Mark Invalid']")).click();
	  Thread.sleep(4000);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
//	  get the transaction ID
	  WebElement baseTable = driver.findElement(By.className("table__overflow"));
	  WebElement cellInfo = baseTable.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
	  beforeCellValue = cellInfo.getText();
	  System.out.println("before transaction ID: " + beforeCellValue);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
//	  navigate to invalid cheques 
	  driver.findElement(By.xpath("(//A[@class='tabs__item'])[2]")).click();
	  Thread.sleep(6000);
	  
//	  get the cheque value
	  WebElement baseTable = driver.findElement(By.className("table__overflow"));
	  WebElement cellInfo = baseTable.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
	  afterCellValue = cellInfo.getText();
	  System.out.println("after transaction ID: " + afterCellValue);
  }

  @BeforeClass
  public void beforeClass() {
//	  navigate to pending cheques 
	  driver.findElement(By.xpath("(//A[@class='tabs__item'])[1]")).click();
	  
	  
//	  driver.findElement(By.xpath("//*[@id='app']/div[4]/aside/div[1]/div[5]/a/div[2]")).click();
  }

  @AfterClass
  public void afterClass() {
	  if (beforeCellValue.equals(afterCellValue)){
		  System.out.println("Cheque rejected successfully");
	  }
	  else{
		  System.out.println("Cheque rejection faild");
	  }
  }

}
