package user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import driver.driverDetails;

public class updateUser extends driverDetails{
	
  //to send update keys
	
  @Test
  public void sendKyes() throws InterruptedException {
	  
	  driver.findElement(By.xpath("(//INPUT[@required='required'])[1]")).sendKeys("00");
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//DIV[@class='btn__content'][text()='Update']")).click();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
	  driver.navigate().refresh();
	  
	  WebElement baseTable = driver.findElement(By.className("table__overflow"));
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  WebElement cellInfo1 = baseTable.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
	  String cellText1 = cellInfo1.getText();
	  System.out.println("User after update : " + cellText1);
	  
	  Thread.sleep(3000);
	  
  }
  
  //to open the update modal
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  WebDriverWait wait2 = new WebDriverWait(driver, 20);
	  wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[10]/main/div/div/div/div[2]/div[1]/table/tbody/tr[1]/td[7]/button[1]/div")));
	  
	  driver.findElement(By.xpath("//*[@id='app']/div[10]/main/div/div/div/div[2]/div[1]/table/tbody/tr[1]/td[7]/button[1]/div")).click();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
  }
  
  //to check the close button
  
//  @AfterMethod
//  public void afterMethod(){
//	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//	  driver.findElement(By.xpath("//*[@id='app']/div[10]/main/div/div/div/div[2]/div[1]/table/tbody/tr[1]/td[7]/button[1]/div")).click();
//	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//	  
//	  driver.findElement(By.xpath("(//DIV[@class='btn__content'][text()='Close'][text()='Close'])[1]")).click();
//	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//  }

}
