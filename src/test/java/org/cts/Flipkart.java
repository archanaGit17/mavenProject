package org.cts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {
	
	static String newWin;
	
	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\subbian\\eclipse-workspace\\Arch\\MavenProj\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		WebElement btn = driver.findElement(By.xpath("//button[text()='✕']"));
		btn.click();
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mobiles",Keys.ENTER);
		File f=new File("C:\\Users\\subbian\\eclipse-workspace\\Arch\\MavenProj\\Excel\\task.xlsx");
		FileOutputStream f1=new FileOutputStream(f);
		Workbook w=new XSSFWorkbook();
		Sheet s=w.createSheet("Flipkart");
		Thread.sleep(3000);
		
		List<WebElement> mobiles = driver.findElements(By.xpath("//div[@id='container']//div//div//a//div[contains(text(),'GB')]"));
		for(int i=0;i<mobiles.size();i++)
		{
			String name=mobiles.get(i).getText();
			Row r=s.createRow(i);
			Cell c=r.createCell(0);
			c.setCellValue(name);
		}
		w.write(f1);
		f1.close();
		
		mobiles.get(4).click();
		String par = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for(String x:child)
		{
			if(!par.equals(x))
			{
				driver.switchTo().window(x);
				WebElement win = driver.findElement(By.xpath("//div[@id='container']//span[contains(text(),'GB')]"));
				newWin=win.getText();
				System.out.println("new window mobile name is: "+newWin);
			}
		}
	    FileInputStream f2=new FileInputStream(f);
	    Cell c=s.getRow(4).getCell(0);
	    String value = c.getStringCellValue();
	    System.out.println("excel value: "+value);
	    
	    if(value.equals(newWin))
	    {
	    	System.out.println("pass");
	    }
	    else
	    {
	    	System.out.println("fail");
	    }
	    
	    driver.quit();
	}
}