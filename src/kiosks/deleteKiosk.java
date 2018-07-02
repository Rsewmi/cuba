package kiosks;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class deleteKiosk extends driver.driverDetails {
	private int rows_count;
  @Test
  public void deleteKiosks() {
	  rows_count = addKiosk.row_number();
	  System.out.println("row count : " + rows_count);
	  
	  driver.findElement(By.xpath("//*[@id='app']/div[11]/main/div/div/div/div[2]/div[1]/table/tbody/tr["+ rows_count +"]/td[7]/button[3]/div")).click();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
//	  try {
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  //driver.findElement(By.xpath("//DIV[@class='btn__content'][text()='Yes']")).click();
		  driver.findElement(By.xpath("//*[@id='app']/div[2]/div/div/div[3]/button[1]")).click();
		  //
		 // driver.findElement(By.cssSelector("#app > div.dialog__content.dialog__content__active > div > div > div.card__actions > button.btn.primary > div")).click();
		  System.out.println("Kiosk deleted");
//	  }
//	  catch(Exception e) {
//		  System.out.println("no yes button");
//	  }
	  

	  
	  
	  
	  
  }
}
