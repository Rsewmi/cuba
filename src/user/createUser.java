package user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import driver.driverDetails;

public class createUser extends driverDetails {
	
  @BeforeClass
  public void openModal(){
	  driver.findElement(By.xpath("(//DIV[@class='btn__content'])[9]")).click();
  }
  
  @Test
  public void sendKeys() throws InterruptedException{
	  
	  WebDriverWait wait2 = new WebDriverWait(driver, 20);
	  wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[6]/div/div/div[2]/div/form/div[1]/div[1]/div[1]")));
	  
	  //select role	  
	  WebElement element = driver.findElement(By.xpath("//*[@id='app']/div[6]/div/div/div[2]/div/form/div[1]/div[1]/div[1]"));
	  Actions actions = new Actions(driver);
	  Thread.sleep(3000);
	  actions.moveToElement(element).click().build().perform();
	   
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("(//DIV[@class='list__tile__title'][text()='superAdmin'][text()='superAdmin'])[2]")).click();
	  //select branch			
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("(//I[@aria-hidden='true'][text()='arrow_drop_down'][text()='arrow_drop_down'])[4]")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("(//DIV[@class='list__tile__title'][text()='Colombo'][text()='Colombo'])[2]")).click();
	  //send username key
	  driver.findElement(By.xpath("(//INPUT[@required='required'])[3]")).sendKeys(stringValue);
	  //send password 
	  driver.findElement(By.xpath("(//INPUT[@required='required'])[4]")).sendKeys(stringValue);
	  //send email
	  driver.findElement(By.xpath("(//INPUT[@required='required'])[5]")).sendKeys(stringValue +"@email.com");
	  
	  //save user details
	  driver.findElement(By.xpath("//DIV[@class='btn__content'][text()='Save']")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  System.out.println("Adding user successfull");
	  
	  //page refresh
	  driver.navigate().refresh();
	  
	  //get the cell value
	  WebElement baseTable = driver.findElement(By.className("table__overflow"));
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  WebElement cellInfo = baseTable.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
	  String cellText = cellInfo.getText();
	  System.out.println("User before update :" + cellText);
	  
	  
	  
  }
}
