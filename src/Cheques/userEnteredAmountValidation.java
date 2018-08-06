package Cheques;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class userEnteredAmountValidation extends driver.driverDetails{
	
	public String beforeCellAmount = null;
	public String afterCellAmount = null;
	public String fixedAmount = "500.00";
	
  @Test
  public void amountValidation() throws InterruptedException {
//	  navigate into first cheque 
	  driver.findElement(By.xpath("//table/tbody/tr[1]/td[8]")).click();
	  Thread.sleep(10000);
	  driver.findElement(By.xpath("//*[@id='app']/div[5]/div/div/div/div[2]/div/div[3]/div[1]/div[2]/div/button[2]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='app']/div[5]/div/div/div/div[2]/div/div[3]/div[2]/div[2]/div/button[1]")).click();
	  Thread.sleep(2000);
	  System.out.println("navigate successful");
	  
//	  enter correct amount
      WebElement toClear = driver.findElement(By.xpath("//INPUT[@required='required']"));
      toClear.sendKeys(Keys.CONTROL + "a");
      toClear.sendKeys(Keys.DELETE);
	  toClear.sendKeys("500");
	  
	  System.out.println("clear the amount and entered the amount");
	  
//	  submit
	  driver.findElement(By.xpath("//DIV[@class='btn__content'][text()='Submit']")).click();
	  driver.findElement(By.xpath("//*[@id='app']/div[5]/div/div/nav/div/div[5]/button")).click();
	  
	  Thread.sleep(2000);
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
//	  get the cheque value
	  WebElement baseTable = driver.findElement(By.className("table__overflow"));
	  WebElement cellInfo = baseTable.findElement(By.xpath("//table/tbody/tr[1]/td[4]"));
	  beforeCellAmount = cellInfo.getText();
	  System.out.println("Cell Amount: " + beforeCellAmount);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
//	  navigate to validated cheques
	  driver.findElement(By.xpath("(//A[@class='tabs__item'])[1]")).click();

	  Thread.sleep(6000);
	  
//	  get the cheque value
	  WebElement baseTable = driver.findElement(By.className("table__overflow"));
	  WebElement cellInfo = baseTable.findElement(By.xpath("//table/tbody/tr[1]/td[4]"));
	  afterCellAmount = cellInfo.getText();
	  System.out.println("Cell Amount: " + afterCellAmount);
	  
  }

  @BeforeClass
  public void beforeClass() {
	  //navigate to pending cheque   
	  driver.findElement(By.xpath("(//A[@class='tabs__item'])[1]")).click();
	  
//	  driver.findElement(By.xpath("//*[@id='app']/div[4]/aside/div[1]/div[5]/a/div[2]")).click();
	  
	  
  }

  @AfterClass
  public void afterClass() {
	  
//	  compare the cheque values 
	  if (beforeCellAmount.equals(afterCellAmount)) {
		  System.out.println("Amount validation failed");
		  
	  }
	  else if (afterCellAmount.equals(fixedAmount)) {
		  System.out.println("Amount validation success");
	  }
	  
	  else {
		  System.out.println("Invalid Validation process");
	  }
  }

}
