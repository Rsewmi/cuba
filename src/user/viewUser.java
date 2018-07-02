package user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import driver.driverDetails;

public class viewUser extends driverDetails {
  @Test
  public void viewUsers(){
	  
	  WebDriverWait wait2 = new WebDriverWait(driver, 20);
	  wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//I[@data-v-57dfeb0f=''][text()='contacts']")));
	  
	  driver.findElement(By.xpath("//I[@data-v-57dfeb0f=''][text()='contacts']")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  System.out.println("View Users Successfull");
  }
}
