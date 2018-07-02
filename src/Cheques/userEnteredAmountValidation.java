package Cheques;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class userEnteredAmountValidation extends driver.driverDetails{
  @Test
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
	  //navigate to pending cheque   
	  driver.findElement(By.xpath("//*[@id='app']/div[14]/main/div/div/div/div[3]/div[1]/div/div/div[2]")).click();
  }

  @AfterClass
  public void afterClass() {
  }

}
