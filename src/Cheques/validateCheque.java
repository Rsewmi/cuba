package Cheques;

//import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class validateCheque extends driver.driverDetails {
	
	public static String cellID1 = null;
	public static String cellID2;
	
	@BeforeClass
	public void beforeMethod(){
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//  Navigate to cheque page
		driver.findElement(By.xpath("//*[@id='app']/div[10]/aside/div[1]/div[5]/a/div[2]")).click();
		System.out.println("before class");
		
		
			  
	}
	
	@BeforeMethod
	public static void returnTransactionID(){
	//  Get the transaction ID first transaction
		WebElement baseTable = driver.findElement(By.className("table__overflow"));
		WebElement cellInfo = baseTable.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
		cellID1 = cellInfo.getText();
		System.out.println("Transaction ID: " + cellID1);
		System.out.println("before method");
	}
	
	@Test
	public void chequeValidation() throws InterruptedException{
	//  Navigate into the cheque
		  
	  driver.findElement(By.xpath("//table/tbody/tr[1]/td[8]")).click();
	  
	  Thread.sleep(10000);
	  
	  
	  System.out.println("test ");
	  driver.findElement(By.xpath("//*[@id='app']/div[5]/div/div/div/div[2]/div/div[3]/div[1]/div[2]/div/button[2]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='app']/div[5]/div/div/div/div[2]/div/div[3]/div[2]/div[2]/div/button[2]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id='app']/div[5]/div/div/nav/div/div[5]/button")).click();
	
	  
	  Thread.sleep(9000);
	}
	
	@AfterClass
	public void afterClass() throws InterruptedException{
	//  Verify whether cheque has been validated
		  
	//  Navigate to validated cheques 
	  driver.findElement(By.xpath("(//A[@class='tabs__item'])[1]")).click();
	  
	  Thread.sleep(5000);
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	//  Get the transaction ID of first transaction
	  WebElement baseTable1 = driver.findElement(By.cssSelector("#undefined > div:nth-child(2) > div > div.table__overflow > table"));
	  WebElement cellInfo = baseTable1.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
	  String cellID2 = cellInfo.getText();
	  System.out.println("Transaction ID after validation: " + cellID2);
	  System.out.println("after class");
	  
//	  String cellID = cellID1;
	  
	  System.out.println("CellID1: "+ cellID1);
	  System.out.println("CellID2: "+ cellID2);


	  if (cellID1.equals(cellID2)){
		  System.out.println("success");
	  }  
	  else {
		  System.out.println("failed");
	  }
	}
  

}
