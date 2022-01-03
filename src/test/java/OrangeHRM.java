import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class OrangeHRM {
  
	WebDriver driver ;
	//Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	
	
	  @Test
	  public void Test1() throws IOException {
		  
		  //Code to take screenshots
		  
		  Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		  ImageIO.write(screenshot.getImage(), "jpg", new File("/Users/chiranjeebsarkar/Desktop/Selenium_Screenshots/Screenshots"));
		  
		  
		 // ImageIO.write(screenshot.getImage(), "jpg", new File("/Users/chiranjeebsarkar/Desktop/Selenium_Screenshots/Screenshots"));
		  
		  driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		  driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		  driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		  driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
		  //Get the name of a particular entry from a table :
		  String Name = driver.findElement(By.xpath("(//td[@class='left'])[7]")).getText();
		  System.out.println(Name);
		  //Get the number of rows in a table 
		  //To get the number of elements from a list in selenium always use findelements and .size() method of selenium.
		  int rows = driver.findElements(By.xpath("//tr[@class='odd' or @class='even']")).size();
		  System.out.println(rows);
		  //To print all the contents of the rows from a table using for loop
		  for(int i =1 ;i<=rows ;i++)
		  {
			  
			  String Contents = driver.findElement(By.xpath("(//tr[@class='odd' or @class='even'])["+i+"]")).getText();
			  System.out.println(Contents);
		  }
		  //To Add a row and check weather the records are added or not 
		  driver.findElement(By.xpath("//input[@name='btnAdd']")).click();
		  //To Select an element from a dropdown :
		  Select User_Role_Dropdown = new Select(driver.findElement(By.xpath("//select[@name='systemUser[userType]']")));
		  User_Role_Dropdown.selectByVisibleText("Admin");
		  driver.findElement(By.xpath("//input[@name='systemUser[employeeName][empName]']")).sendKeys("Sourav Halder");
		  driver.findElement(By.xpath("//input[@name='systemUser[userName]']")).sendKeys("SH1234");
		  Select Status_Dropdown = new Select(driver.findElement(By.xpath("//select[@name='systemUser[status]']")));
		  Status_Dropdown.selectByVisibleText("Disabled");
		  driver.findElement(By.xpath("//input[@name='systemUser[password]']")).sendKeys("Sh@12345");
		  driver.findElement(By.xpath("//input[@name='systemUser[confirmPassword]']")).sendKeys("Sh@12345");
		  driver.findElement(By.xpath("//input[@name='btnSave']")).click();
		  
	  }
	  @BeforeClass
	  public void beforeClass() {
		  WebDriverManager.chromedriver().setup();
		  
		  
		   driver = new ChromeDriver();
		   driver.get("https://opensource-demo.orangehrmlive.com/");

	  }

	  
	  
	  
	  @AfterClass
	  public void afterClass() {
		  
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.quit();
		  
	  }


}
