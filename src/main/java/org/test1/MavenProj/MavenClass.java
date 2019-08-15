package org.test1.MavenProj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenClass 
{
 public static void main(String[] args) 
  {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\subbian\\eclipse-workspace\\Arch\\MavenProj\\driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.adactin.com/HotelApp/");
	WebElement u=driver.findElement(By.id("username"));
	u.sendKeys("archana@gmail.com");
	WebElement p=driver.findElement(By.id("password"));
	p.sendKeys("123456");
	WebElement l=driver.findElement(By.id("login"));
	l.click();
	
  }
}
