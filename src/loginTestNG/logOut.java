package loginTestNG;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import driver.driverDetails;

public class logOut extends driverDetails {
	
	
  @AfterSuite
  public void afterSuite() throws InterruptedException{
	
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("(//DIV[@class='btn__content'])[8]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//DIV[@data-v-57dfeb0f=''][text()='Logout']")).click();
	    driver.close();
	    System.out.print("logout successfull");
  }

}
