package kioskVideo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class addKioskVideo extends driver.driverDetails {
  @Test
  public void attachVideo() throws InterruptedException {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Thread.sleep(2000);
//	  select video language to sinhala
	  driver.findElement(By.xpath("//*[@id='app']/div[4]/div/div/div[2]/div/form/div[1]/div[1]")).click();
	  System.out.println("clicked the dropdown");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//*[@id='app']/div[5]/div/div/div[1]/a/div")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  System.out.println("Selected sinhala language");
	  
//	  Select a video from local storage
	  driver.findElement(By.xpath("//INPUT[@data-v-0080fb1f='']")).sendKeys("/home/thinkcube/Java Essential/0. Introduction/0-1. Welcome.mp4");

  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver.findElement(By.xpath("//*[@id='app']/div[4]/aside/div[1]/div[8]/a/div[2]/div")).click();
	  System.out.println("navigate to kiosk video");
	  
	  
	  driver.findElement(By.xpath("(//DIV[@class='btn__content'])[8]")).click();
	  System.out.println("open add new kiosk video modal");
  }
  
  @AfterMethod
  public void afterMethod(){
//	  driver.findElement(By.xpath("(//DIV[@class='btn__content'][text()='Close'])[2]"));
//	  System.out.println("closed");
//	  
//	  driver.quit();
	  
	
  }

}
