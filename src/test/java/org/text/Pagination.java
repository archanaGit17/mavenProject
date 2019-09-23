package org.text;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination {
	static WebDriver driver;
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\subbian\\eclipse-workspace\\Arch\\MavenProj\\driver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://www.google.co.in/");
	driver.findElement(By.xpath("//a[text()='No, thanks']")).click();
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("java", Keys.ENTER);
	goToPage("5");
	Thread.sleep(3000);
	moveToPage("3");
	
}
public static void goToPage(String pageNo) {
	List<WebElement> pages=driver.findElements(By.xpath("//table[@id='nav']/tbody/tr/td"));
	for(WebElement pg: pages)
	{
		String no=pg.getText();
		if(no.equals(pageNo))
		{
			pg.findElement(By.tagName("a")).click();
			break;
		}
	}
 }

private static void moveToPage(String page) {
	String loc="//a[@aria-label='Page $']";
	String newloc=loc.replace("$", page);
	driver.findElement(By.xpath(newloc)).click();
 }
}